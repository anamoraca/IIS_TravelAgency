package com.example.TravelAgency.arrangements.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departure extends BaseEntity {

    @ManyToOne(optional=false)
    private TravelArrangement arrangement;

    @Column(nullable=false)
    private LocalDate startDate;

    @Column(nullable=true)
    private LocalDate endDate; // null for DAY_TRIP

    @Column(nullable=false)
    private int capacityTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private DepartureStatus status = DepartureStatus.SCHEDULED;
}