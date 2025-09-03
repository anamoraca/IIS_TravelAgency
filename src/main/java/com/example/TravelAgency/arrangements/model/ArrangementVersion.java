package com.example.TravelAgency.arrangements.model;

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
public class ArrangementVersion extends BaseEntity {
    @ManyToOne(optional=false)
    private TravelArrangement arrangement;

    @Column(nullable=false)
    private int versionNo;

    @Column(nullable=false)
    private Instant changedAt = Instant.now();

    @Column(length=1024)
    private String changeNote;
}