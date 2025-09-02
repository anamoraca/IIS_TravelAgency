package com.example.OnlyBuns.service;

import com.example.OnlyBuns.dto.ActivityReviewDto;
import com.example.OnlyBuns.mapper.ActivityReviewMapper;
import com.example.OnlyBuns.model.ActivityBooking;
import com.example.OnlyBuns.model.ActivityReview;
import com.example.OnlyBuns.model.User;
import com.example.OnlyBuns.repository.ActivityBookingRepository;
import com.example.OnlyBuns.repository.ActivityReviewRepository;
import com.example.OnlyBuns.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityReviewService {

    private final ActivityReviewRepository reviewRepo;
    private final UserRepository userRepo;
    private final ActivityBookingRepository bookingRepo;

    public ActivityReviewService(ActivityReviewRepository reviewRepo,
                                 UserRepository userRepo,
                                 ActivityBookingRepository bookingRepo) {
        this.reviewRepo = reviewRepo;
        this.userRepo = userRepo;
        this.bookingRepo = bookingRepo;
    }

    public List<ActivityReviewDto> list() {
        return reviewRepo.findAll().stream()
                .map(ActivityReviewMapper::toDto)
                .collect(Collectors.toList());
    }

    public ActivityReviewDto get(Long id) {
        ActivityReview e = reviewRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ActivityReview not found: " + id));
        return ActivityReviewMapper.toDto(e);
    }

    public ActivityReviewDto create(ActivityReviewDto dto) {
        User user = userRepo.findById(dto.userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + dto.userId));
        ActivityBooking booking = bookingRepo.findById(dto.activityBookingId)
                .orElseThrow(() -> new EntityNotFoundException("ActivityBooking not found: " + dto.activityBookingId));
        ActivityReview saved = reviewRepo.save(ActivityReviewMapper.toEntity(dto, user, booking));
        return ActivityReviewMapper.toDto(saved);
    }

    public ActivityReviewDto patch(Long id, ActivityReviewDto dto) {
        ActivityReview e = reviewRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ActivityReview not found: " + id));

        User user = null;
        if (dto.userId != null) {
            user = userRepo.findById(dto.userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found: " + dto.userId));
        }
        ActivityBooking booking = null;
        if (dto.activityBookingId != null) {
            booking = bookingRepo.findById(dto.activityBookingId)
                    .orElseThrow(() -> new EntityNotFoundException("ActivityBooking not found: " + dto.activityBookingId));
        }

        ActivityReviewMapper.apply(e, dto, user, booking);
        return ActivityReviewMapper.toDto(reviewRepo.save(e));
    }

    public void delete(Long id) {
        if (!reviewRepo.existsById(id)) {
            throw new EntityNotFoundException("ActivityReview not found: " + id);
        }
        reviewRepo.deleteById(id);
    }
}
