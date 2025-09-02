package com.example.OnlyBuns.mapper;

import com.example.OnlyBuns.dto.ActivityBookingDto;
import com.example.OnlyBuns.model.ActivityBooking;
import com.example.OnlyBuns.model.ActivitySchedule;
import com.example.OnlyBuns.model.User;

import java.math.BigDecimal;

public class ActivityBookingMapper {

    public static ActivityBooking toEntity(ActivityBookingDto dto, User user, ActivitySchedule schedule) {
        ActivityBooking e = new ActivityBooking();
        e.setUser(user);
        e.setActivitySchedule(schedule);
        e.setBookingDate(dto.bookingDate);
        e.setNumberOfParticipants(dto.numberOfParticipants);
        e.setTotalPrice(dto.totalPrice != null ? dto.totalPrice : BigDecimal.ZERO);
        e.setIsCancelled(Boolean.TRUE.equals(dto.isCancelled));
        e.setCancelledAt(dto.cancelledAt);
        e.setCancellationReason(dto.cancellationReason);
        e.setPetsIncluded(Boolean.TRUE.equals(dto.petsIncluded));
        return e;
    }

    public static void apply(ActivityBooking e, ActivityBookingDto dto, User user, ActivitySchedule schedule) {
        if (user != null) e.setUser(user);
        if (schedule != null) e.setActivitySchedule(schedule);
        if (dto.bookingDate != null) e.setBookingDate(dto.bookingDate);
        if (dto.numberOfParticipants != null) e.setNumberOfParticipants(dto.numberOfParticipants);
        if (dto.totalPrice != null) e.setTotalPrice(dto.totalPrice);
        if (dto.isCancelled != null) e.setIsCancelled(dto.isCancelled);
        if (dto.cancelledAt != null) e.setCancelledAt(dto.cancelledAt);
        if (dto.cancellationReason != null) e.setCancellationReason(dto.cancellationReason);
        if (dto.petsIncluded != null) e.setPetsIncluded(dto.petsIncluded);
    }

    public static ActivityBookingDto toDto(ActivityBooking e) {
        ActivityBookingDto dto = new ActivityBookingDto();
        dto.id = e.getId();
        dto.userId = e.getUser() != null ? e.getUser().getId() : null;
        dto.activityScheduleId = e.getActivitySchedule() != null ? e.getActivitySchedule().getId() : null;
        dto.bookingDate = e.getBookingDate();
        dto.numberOfParticipants = e.getNumberOfParticipants();
        dto.totalPrice = e.getTotalPrice();
        dto.isCancelled = e.getIsCancelled();
        dto.cancelledAt = e.getCancelledAt();
        dto.cancellationReason = e.getCancellationReason();
        dto.petsIncluded = e.getPetsIncluded();
        return dto;
    }
}
