package com.example.TravelAgency.arrangements.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Itinerary extends BaseEntity {

    @ManyToOne(optional=false)
    private Departure departure;

    @Column(nullable=false)
    private int dayNo; // for MULTI_DAY start at 1; for DAY_TRIP use 1
    @Column(nullable=false)
    private String title;

    @Column(length=2048)
    private String description;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;
}