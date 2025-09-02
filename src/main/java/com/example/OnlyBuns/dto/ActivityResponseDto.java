package com.example.OnlyBuns.dto;

import com.example.OnlyBuns.model.ActivityAgeGroup;
import com.example.OnlyBuns.model.Season;
import com.example.OnlyBuns.model.Status;

import java.time.LocalDateTime;

public class ActivityResponseDto {
    public Long id;
    public String name;
    public String description;
    public Status status;
    public int minCapacity;
    public int maxCapacity;
    public Double price;
    public Double lengthInMin;
    public Long userId;

    public Boolean isPetFriendly;
    public Boolean isFamilyFriendly;
    public ActivityAgeGroup targetAgeGroup;
    public Boolean isOutdoor;
    public Boolean isAdventure;
    public Season season;
    public Integer difficulty;
    public LocalDateTime publishedTime;
    public LocalDateTime archiveTime;
    public Boolean isPremiumOption;
    public Float value;
}
