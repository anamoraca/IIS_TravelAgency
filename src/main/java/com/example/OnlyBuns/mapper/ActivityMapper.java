package com.example.OnlyBuns.mapper;

import com.example.OnlyBuns.dto.ActivityCreateDto;
import com.example.OnlyBuns.dto.ActivityResponseDto;
import com.example.OnlyBuns.dto.ActivityUpdateDto;
import com.example.OnlyBuns.model.Activity;
import com.example.OnlyBuns.model.User;

public class ActivityMapper {

    public static Activity toEntity(ActivityCreateDto dto, User user) {
        Activity a = new Activity();
        a.setName(dto.name);
        a.setDescription(dto.description);
        a.setStatus(dto.status);
        a.setMinCapacity(dto.minCapacity);
        a.setMaxCapacity(dto.maxCapacity);
        a.setUser(user);

        a.setPetFriendly(Boolean.TRUE.equals(dto.isPetFriendly));
        a.setFamilyFriendly(Boolean.TRUE.equals(dto.isFamilyFriendly));
        a.setTargetAgeGroup(dto.targetAgeGroup);
        a.setOutdoor(Boolean.TRUE.equals(dto.isOutdoor));
        a.setAdventure(Boolean.TRUE.equals(dto.isAdventure));
        a.setSeason(dto.season);
        a.setDifficulty(dto.difficulty);
        a.setPrice(dto.price);
        a.setLengthInMin(dto.lengthInMin);
        a.setPremiumOption(Boolean.TRUE.equals(dto.isPremiumOption));
        a.setValue(dto.value != null ? dto.value : 0f);
        return a;
    }

    public static void applyPatch(Activity a, ActivityUpdateDto dto) {
        if (dto.name != null) a.setName(dto.name);
        if (dto.description != null) a.setDescription(dto.description);
        if (dto.status != null) a.setStatus(dto.status);
        if (dto.minCapacity != null) a.setMinCapacity(dto.minCapacity);
        if (dto.maxCapacity != null) a.setMaxCapacity(dto.maxCapacity);
        if (dto.price != null) a.setPrice(dto.price);
        if (dto.isPremiumOption != null) a.setPremiumOption(dto.isPremiumOption);
    }

    public static ActivityResponseDto toDto(Activity a) {
        ActivityResponseDto dto = new ActivityResponseDto();
        dto.id = a.getId();
        dto.name = a.getName();
        dto.description = a.getDescription();
        dto.status = a.getStatus();
        dto.minCapacity = a.getMinCapacity();
        dto.maxCapacity = a.getMaxCapacity();
        dto.price = a.getPrice();
        dto.lengthInMin = a.getLengthInMin();
        dto.userId = a.getUser() != null ? a.getUser().getId() : null;

        dto.isPetFriendly = a.isPetFriendly();
        dto.isFamilyFriendly = a.isFamilyFriendly();
        dto.targetAgeGroup = a.getTargetAgeGroup();
        dto.isOutdoor = a.isOutdoor();
        dto.isAdventure = a.isAdventure();
        dto.season = a.getSeason();
        dto.difficulty = a.getDifficulty();
        dto.publishedTime = a.getPublishedTime();
        dto.archiveTime = a.getArchiveTime();
        dto.isPremiumOption = a.isPremiumOption();
        dto.value = a.getValue();
        return dto;
    }
}
