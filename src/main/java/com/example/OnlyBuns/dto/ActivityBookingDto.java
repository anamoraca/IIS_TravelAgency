package com.example.OnlyBuns.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ActivityBookingDto {
    public Long id;

    @NotNull public Long userId;
    @NotNull public Long activityScheduleId;

    @NotNull public LocalDateTime bookingDate;

    @NotNull @Min(1)
    public Integer numberOfParticipants;

    @NotNull
    public BigDecimal totalPrice;

    public Boolean isCancelled;
    public LocalDateTime cancelledAt;
    public String cancellationReason;

    public Boolean petsIncluded;
}
