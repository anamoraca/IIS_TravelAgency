package com.example.OnlyBuns.mapper;

import com.example.OnlyBuns.dto.ActivityBookingParticipantDto;
import com.example.OnlyBuns.model.ActivityBooking;
import com.example.OnlyBuns.model.ActivityBookingParticipant;

import java.time.LocalDate;
import java.time.Period;

public class ActivityBookingParticipantMapper {

    public static ActivityBookingParticipant toEntity(ActivityBookingParticipantDto dto, ActivityBooking booking) {
        ActivityBookingParticipant e = new ActivityBookingParticipant();
        e.setActivityBooking(booking);
        e.setFirstName(dto.firstName);
        e.setLastName(dto.lastName);
        e.setEmail(dto.email);
        e.setDateOfBirth(dto.dateOfBirth);
        e.setSpecialRequirements(dto.specialRequirements);
        e.setAllergy(dto.allergy);
        e.setMedicalCondition(dto.medicalCondition);
        e.setPreferences(dto.preferences);
        return e;
    }

    public static void apply(ActivityBookingParticipant e, ActivityBookingParticipantDto dto, ActivityBooking booking) {
        if (booking != null) e.setActivityBooking(booking);
        if (dto.firstName != null) e.setFirstName(dto.firstName);
        if (dto.lastName != null) e.setLastName(dto.lastName);
        if (dto.email != null) e.setEmail(dto.email);
        if (dto.dateOfBirth != null) e.setDateOfBirth(dto.dateOfBirth);
        if (dto.specialRequirements != null) e.setSpecialRequirements(dto.specialRequirements);
        if (dto.allergy != null) e.setAllergy(dto.allergy);
        if (dto.medicalCondition != null) e.setMedicalCondition(dto.medicalCondition);
        if (dto.preferences != null) e.setPreferences(dto.preferences);
    }

    public static ActivityBookingParticipantDto toDto(ActivityBookingParticipant e) {
        ActivityBookingParticipantDto dto = new ActivityBookingParticipantDto();
        dto.id = e.getId();
        dto.activityBookingId = e.getActivityBooking() != null ? e.getActivityBooking().getId() : null;
        dto.firstName = e.getFirstName();
        dto.lastName = e.getLastName();
        dto.email = e.getEmail();
        dto.dateOfBirth = e.getDateOfBirth();
        dto.specialRequirements = e.getSpecialRequirements();
        dto.allergy = e.getAllergy();
        dto.medicalCondition = e.getMedicalCondition();
        dto.preferences = e.getPreferences();
        dto.isChild = isChild(e.getDateOfBirth());
        return dto;
    }

    private static boolean isChild(LocalDate dob) {
        return dob != null && Period.between(dob, LocalDate.now()).getYears() < 18;
    }
}
