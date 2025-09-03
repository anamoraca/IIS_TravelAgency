package com.example.TravelAgency.arrangements.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItineraryActivity extends BaseEntity {

    @ManyToOne(optional=false)
    private Itinerary itinerary;

    private LocalTime startTime;
    private LocalTime endTime;

    @Column(nullable=false)
    private String activityTitle;

    @Column(length=2048)
    private String activityDescription;

    private BigDecimal extraCost;
    private String providerNote;
}