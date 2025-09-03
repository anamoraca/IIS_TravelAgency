package com.example.TravelAgency.arrangements.model;


import com.example.TravelAgency.model.User;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelArrangement extends BaseEntity {

    @ManyToOne(optional=false)
    private Destination destination;

    @ManyToOne(optional=false)
    private User createdBy;

    @Column(nullable=false)
    private String title;

    @Column(length=2048)
    private String summary;

    @Column(nullable=false)
    private BigDecimal basePricePerPerson;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private TransportType transportType;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private AccommodationType accommodationType;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private ArrangementType type; // DAY_TRIP or MULTI_DAY

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private ArrangementStatus status = ArrangementStatus.DRAFT;
}