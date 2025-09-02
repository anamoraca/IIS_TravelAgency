package com.example.OnlyBuns.service;

import com.example.OnlyBuns.dto.ActivityScheduleDto;
import com.example.OnlyBuns.mapper.ActivityScheduleMapper;
import com.example.OnlyBuns.model.Activity;
import com.example.OnlyBuns.model.ActivitySchedule;
import com.example.OnlyBuns.repository.ActivityRepository;
import com.example.OnlyBuns.repository.ActivityScheduleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityScheduleService {

    private final ActivityScheduleRepository scheduleRepo;
    private final ActivityRepository activityRepo;

    public ActivityScheduleService(ActivityScheduleRepository scheduleRepo, ActivityRepository activityRepo) {
        this.scheduleRepo = scheduleRepo;
        this.activityRepo = activityRepo;
    }

    public List<ActivityScheduleDto> list() {
        return scheduleRepo.findAll()
                .stream()
                .map(ActivityScheduleMapper::toDto)
                .collect(Collectors.toList());
    }

    public ActivityScheduleDto get(Long id) {
        ActivitySchedule e = scheduleRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ActivitySchedule not found: " + id));
        return ActivityScheduleMapper.toDto(e);
    }

    public ActivityScheduleDto create(ActivityScheduleDto dto) {
        validateDates(dto);
        Activity activity = activityRepo.findById(dto.activityId)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found: " + dto.activityId));
        ActivitySchedule saved = scheduleRepo.save(ActivityScheduleMapper.toEntity(dto, activity));
        return ActivityScheduleMapper.toDto(saved);
    }


    public ActivityScheduleDto patch(Long id, ActivityScheduleDto dto) {
        ActivitySchedule e = scheduleRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ActivitySchedule not found: " + id));

        // If times are provided, validate their ordering
        validateDatesIfProvided(dto);

        Activity activity = null;
        if (dto.activityId != null) {
            activity = activityRepo.findById(dto.activityId)
                    .orElseThrow(() -> new EntityNotFoundException("Activity not found: " + dto.activityId));
        }

        ActivityScheduleMapper.apply(e, dto, activity);
        return ActivityScheduleMapper.toDto(scheduleRepo.save(e));
    }

    public void delete(Long id) {
        if (!scheduleRepo.existsById(id)) {
            throw new EntityNotFoundException("ActivitySchedule not found: " + id);
        }
        scheduleRepo.deleteById(id);
    }

    private void validateDates(ActivityScheduleDto dto) {
        if (dto.startTime.isAfter(dto.endTime) || dto.startTime.isEqual(dto.endTime)) {
            throw new IllegalArgumentException("startTime must be before endTime");
        }
    }

    private void validateDatesIfProvided(ActivityScheduleDto dto) {
        if (dto.startTime != null && dto.endTime != null) {
            validateDates(dto);
        }
      }
}
