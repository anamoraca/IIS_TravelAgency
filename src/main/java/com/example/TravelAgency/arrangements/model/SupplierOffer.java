package com.example.TravelAgency.arrangements.model;

import com.example.TravelAgency.model.User;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierOffer extends BaseEntity {

    @ManyToOne(optional=false)
    private TravelArrangement arrangement;

    @ManyToOne(optional=false)
    private Supplier supplier;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private OfferType offerType; // HOTEL/AIRLINE/BUS/GUIDE

    @Column(length=4096)
    private String terms; // free text terms

    @Column(nullable=false)
    private BigDecimal priceTotal;

    private Instant requestSentAt; // when operator sent the inquiry
    private Instant receivedAt; // when supplier submitted

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private OfferStatus status = OfferStatus.SENT;

    @ManyToOne
    private User decisionBy;

    private Instant decisionAt; // accept/reject
}