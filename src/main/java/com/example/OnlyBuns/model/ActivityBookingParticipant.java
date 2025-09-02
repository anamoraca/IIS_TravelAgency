package com.example.OnlyBuns.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ActivityBookingParticipants")
public class ActivityBookingParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "activity_booking_id", nullable = false)
    private ActivityBooking activityBooking;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "special_requirements")
    private String specialRequirements;

    @Enumerated(EnumType.STRING)
    @Column(name = "allergy")
    private Allergy allergy;

    @Enumerated(EnumType.STRING)
    @Column(name = "medical_condition")
    private MedicalCondition medicalCondition;

    @Column(name = "preferences")
    private String preferences;

    // Derived field: not stored in DB, computed on the fly
    @Transient
    public boolean isChild() {
        return dateOfBirth != null &&
                Period.between(dateOfBirth, LocalDate.now()).getYears() < 18;
    }
}
