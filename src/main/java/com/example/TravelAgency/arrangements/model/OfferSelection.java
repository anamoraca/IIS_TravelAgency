package com.example.TravelAgency.arrangements.model;

import com.example.TravelAgency.model.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferSelection extends BaseEntity {

    @ManyToOne(optional=false)
    private TravelArrangement arrangement;

    @ManyToOne(optional=false)
    private SupplierOffer offer; // chosen offer

    @ManyToOne(optional=false)
    private User selectedBy;

    @Column(nullable=false)
    private Instant selectedAt = Instant.now();
}
