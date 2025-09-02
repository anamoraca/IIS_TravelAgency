package com.example.OnlyBuns.dto;

import com.example.OnlyBuns.model.Allergy;
import com.example.OnlyBuns.model.MedicalCondition;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ActivityBookingParticipantDto {
    public Long id;

    @NotNull public Long activityBookingId;

    @NotBlank public String firstName;
    @NotBlank public String lastName;

    @NotBlank @Email
    public String email;

    public LocalDate dateOfBirth;          // optional
    public String specialRequirements;     // optional
    public Allergy allergy;                // optional enum
    public MedicalCondition medicalCondition; // optional enum
    public String preferences;             // optional


    public Boolean isChild;
}
