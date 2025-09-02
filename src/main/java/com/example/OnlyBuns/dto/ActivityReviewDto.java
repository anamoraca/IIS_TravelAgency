package com.example.OnlyBuns.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ActivityReviewDto {
    public Long id;

    @NotNull public Long userId;
    @NotNull public Long activityBookingId;

    @NotNull @Min(1) @Max(5)
    public Integer overallRating;

    public String comment;

    public LocalDateTime createdAt;

    @NotNull @Min(1) @Max(5)
    public Integer organizationRating;

    @NotNull @Min(1) @Max(5)
    public Integer guideRating;

    @NotNull @Min(1) @Max(5)
    public Integer valueForMoneyRating;

    @NotNull @Min(1) @Max(5)
    public Integer safetyRating;

    @NotNull @Min(1) @Max(5)
    public Integer funRating;

    public Boolean wouldRevisit;
}
