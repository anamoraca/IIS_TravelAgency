package com.example.OnlyBuns.mapper;

import com.example.OnlyBuns.dto.ActivityScheduleDto;
import com.example.OnlyBuns.model.Activity;
import com.example.OnlyBuns.model.ActivitySchedule;

public class ActivityScheduleMapper {

    public static ActivitySchedule toEntity(ActivityScheduleDto dto, Activity activity) {
        ActivitySchedule e = new ActivitySchedule();
        e.setActivity(activity);
        e.setStartTime(dto.startTime);
        e.setEndTime(dto.endTime);
        return e;
    }

    public static void apply(ActivitySchedule e, ActivityScheduleDto dto, Activity activity) {
        if (activity != null) e.setActivity(activity);
        if (dto.startTime != null) e.setStartTime(dto.startTime);
        if (dto.endTime != null) e.setEndTime(dto.endTime);
    }

    public static ActivityScheduleDto toDto(ActivitySchedule e) {
        ActivityScheduleDto dto = new ActivityScheduleDto();
        dto.id = e.getId();
        dto.activityId = e.getActivity() != null ? e.getActivity().getId() : null;
        dto.startTime = e.getStartTime();
        dto.endTime = e.getEndTime();
        return dto;
    }
}
