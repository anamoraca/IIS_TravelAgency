package com.example.OnlyBuns.dto;

import com.example.OnlyBuns.model.ActivityAgeGroup;
import com.example.OnlyBuns.model.Season;
import com.example.OnlyBuns.model.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ActivityCreateDto {
    @NotBlank public String name;
    @NotBlank public String description;
    @NotNull public Status status;

    @NotNull public Integer minCapacity;
    @NotNull public Integer maxCapacity;

    @NotNull public Long userId;

    public Boolean isPetFriendly = false;
    public Boolean isFamilyFriendly = false;
    public ActivityAgeGroup targetAgeGroup;
    public Boolean isOutdoor = false;
    public Boolean isAdventure = false;
    public Season season;
    public Integer difficulty;
    @NotNull public Double price;
    @NotNull public Double lengthInMin;
    public Boolean isPremiumOption = false;
    public Float value = 0f;
}
