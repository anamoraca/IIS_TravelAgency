package com.example.OnlyBuns.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ActivityScheduleDto {
    public Long id;
    @NotNull public Long activityId;
    @NotNull public LocalDateTime startTime;
    @NotNull public LocalDateTime endTime;
}
