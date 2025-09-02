package com.example.OnlyBuns.mapper;

import com.example.OnlyBuns.dto.ActivityReviewDto;
import com.example.OnlyBuns.model.ActivityBooking;
import com.example.OnlyBuns.model.ActivityReview;
import com.example.OnlyBuns.model.User;

import java.time.LocalDateTime;

public class ActivityReviewMapper {

    public static ActivityReview toEntity(ActivityReviewDto dto, User user, ActivityBooking booking) {
        ActivityReview e = new ActivityReview();
        e.setUser(user);
        e.setActivityBooking(booking);
        e.setOverallRating(dto.overallRating);
        e.setComment(dto.comment);
        e.setCreatedAt(dto.createdAt != null ? dto.createdAt : LocalDateTime.now());
        e.setOrganizationRating(dto.organizationRating);
        e.setGuideRating(dto.guideRating);
        e.setValueForMoneyRating(dto.valueForMoneyRating);
        e.setSafetyRating(dto.safetyRating);
        e.setFunRating(dto.funRating);
        e.setWouldRevisit(Boolean.TRUE.equals(dto.wouldRevisit));
        return e;
    }

    public static void apply(ActivityReview e, ActivityReviewDto dto, User user, ActivityBooking booking) {
        if (user != null) e.setUser(user);
        if (booking != null) e.setActivityBooking(booking);
        if (dto.overallRating != null) e.setOverallRating(dto.overallRating);
        if (dto.comment != null) e.setComment(dto.comment);
        if (dto.organizationRating != null) e.setOrganizationRating(dto.organizationRating);
        if (dto.guideRating != null) e.setGuideRating(dto.guideRating);
        if (dto.valueForMoneyRating != null) e.setValueForMoneyRating(dto.valueForMoneyRating);
        if (dto.safetyRating != null) e.setSafetyRating(dto.safetyRating);
        if (dto.funRating != null) e.setFunRating(dto.funRating);
        if (dto.wouldRevisit != null) e.setWouldRevisit(dto.wouldRevisit);
    }

    public static ActivityReviewDto toDto(ActivityReview e) {
        ActivityReviewDto dto = new ActivityReviewDto();
        dto.id = e.getId();
        dto.userId = e.getUser() != null ? e.getUser().getId() : null;
        dto.activityBookingId = e.getActivityBooking() != null ? e.getActivityBooking().getId() : null;
        dto.overallRating = e.getOverallRating();
        dto.comment = e.getComment();
        dto.createdAt = e.getCreatedAt();
        dto.organizationRating = e.getOrganizationRating();
        dto.guideRating = e.getGuideRating();
        dto.valueForMoneyRating = e.getValueForMoneyRating();
        dto.safetyRating = e.getSafetyRating();
        dto.funRating = e.getFunRating();
        dto.wouldRevisit = e.getWouldRevisit();
        return dto;
    }
}
