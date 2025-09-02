package com.example.OnlyBuns.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ActivityReviews")
public class ActivityReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "activity_booking_id", nullable = false)
    private ActivityBooking activityBooking;

    @Column(name = "overall_rating", nullable = false)
    private Integer overallRating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "organization_rating", nullable = false)
    private Integer organizationRating;

    @Column(name = "guide_rating", nullable = false)
    private Integer guideRating;

    @Column(name = "value_for_money_rating", nullable = false)
    private Integer valueForMoneyRating;

    @Column(name = "safety_rating", nullable = false)
    private Integer safetyRating;

    @Column(name = "fun_rating", nullable = false)
    private Integer funRating;

    @Column(name = "would_revisit", nullable = false)
    private Boolean wouldRevisit;
}
