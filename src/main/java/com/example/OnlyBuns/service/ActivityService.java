package com.example.OnlyBuns.service;

import com.example.OnlyBuns.dto.ActivityCreateDto;
import com.example.OnlyBuns.dto.ActivityResponseDto;
import com.example.OnlyBuns.dto.ActivityUpdateDto;
import com.example.OnlyBuns.mapper.ActivityMapper;
import com.example.OnlyBuns.model.Activity;
import com.example.OnlyBuns.model.User;
import com.example.OnlyBuns.repository.ActivityRepository;
import com.example.OnlyBuns.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public List<ActivityResponseDto> getAll() {
        return activityRepository.findAll()
                .stream().map(ActivityMapper::toDto)
                .collect(Collectors.toList());
    }

    public ActivityResponseDto getById(Long id) {
        Activity a = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found: " + id));
        return ActivityMapper.toDto(a);
    }

    public ActivityResponseDto create(ActivityCreateDto dto) {
        User user = userRepository.findById(dto.userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + dto.userId));
        Activity a = ActivityMapper.toEntity(dto, user);
        return ActivityMapper.toDto(activityRepository.save(a));
    }

    /** PATCH – only a few fields are updatable */
    public ActivityResponseDto patch(Long id, ActivityUpdateDto dto) {
        Activity a = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found: " + id));
        ActivityMapper.applyPatch(a, dto);
        return ActivityMapper.toDto(activityRepository.save(a));
    }

    public void delete(Long id) {
        if (!activityRepository.existsById(id)) {
            throw new EntityNotFoundException("Activity not found: " + id);
        }
        activityRepository.deleteById(id);
    }
}
