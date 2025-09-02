package com.example.OnlyBuns.service;

import com.example.OnlyBuns.dto.ActivityBookingDto;
import com.example.OnlyBuns.mapper.ActivityBookingMapper;
import com.example.OnlyBuns.model.ActivityBooking;
import com.example.OnlyBuns.model.ActivitySchedule;
import com.example.OnlyBuns.model.User;
import com.example.OnlyBuns.repository.ActivityBookingRepository;
import com.example.OnlyBuns.repository.ActivityScheduleRepository;
import com.example.OnlyBuns.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityBookingService {

    private final ActivityBookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final ActivityScheduleRepository scheduleRepo;

    public ActivityBookingService(ActivityBookingRepository bookingRepo,
                                  UserRepository userRepo,
                                  ActivityScheduleRepository scheduleRepo) {
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.scheduleRepo = scheduleRepo;
    }

    public List<ActivityBookingDto> list() {
        return bookingRepo.findAll().stream()
                .map(ActivityBookingMapper::toDto)
                .collect(Collectors.toList());
    }

    public ActivityBookingDto get(Long id) {
        ActivityBooking e = bookingRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ActivityBooking not found: " + id));
        return ActivityBookingMapper.toDto(e);
    }

    public ActivityBookingDto create(ActivityBookingDto dto) {
        validateCreate(dto);

        User user = userRepo.findById(dto.userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + dto.userId));

        ActivitySchedule schedule = scheduleRepo.findById(dto.activityScheduleId)
                .orElseThrow(() -> new EntityNotFoundException("ActivitySchedule not found: " + dto.activityScheduleId));


        if (Boolean.TRUE.equals(dto.isCancelled) && dto.cancelledAt == null) {
            dto.cancelledAt = LocalDateTime.now();
        }
        ActivityBooking saved = bookingRepo.save(ActivityBookingMapper.toEntity(dto, user, schedule));
        return ActivityBookingMapper.toDto(saved);
    }


    public ActivityBookingDto patch(Long id, ActivityBookingDto dto) {
        ActivityBooking e = bookingRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ActivityBooking not found: " + id));


        User user = null;
        if (dto.userId != null) {
            user = userRepo.findById(dto.userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found: " + dto.userId));
        }
        ActivitySchedule schedule = null;
        if (dto.activityScheduleId != null) {
            schedule = scheduleRepo.findById(dto.activityScheduleId)
                    .orElseThrow(() -> new EntityNotFoundException("ActivitySchedule not found: " + dto.activityScheduleId));
        }

        if (dto.isCancelled != null) {
            if (dto.isCancelled && dto.cancelledAt == null) {
                dto.cancelledAt = LocalDateTime.now();
            }
        }

        if (dto.numberOfParticipants != null && dto.numberOfParticipants < 1) {
            throw new IllegalArgumentException("numberOfParticipants must be >= 1");
        }

        ActivityBookingMapper.apply(e, dto, user, schedule);
        return ActivityBookingMapper.toDto(bookingRepo.save(e));
    }

    public void delete(Long id) {
        if (!bookingRepo.existsById(id)) {
            throw new EntityNotFoundException("ActivityBooking not found: " + id);
        }
        bookingRepo.deleteById(id);
    }

    private void validateCreate(ActivityBookingDto dto) {
        if (dto.numberOfParticipants == null || dto.numberOfParticipants < 1) {
            throw new IllegalArgumentException("numberOfParticipants must be >= 1");
        }
        if (dto.totalPrice == null) {
            throw new IllegalArgumentException("totalPrice is required");
        }
        if (dto.bookingDate == null) {
            throw new IllegalArgumentException("bookingDate is required");
        }
    }
}
