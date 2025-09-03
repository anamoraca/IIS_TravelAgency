package com.example.TravelAgency.arrangements.model;


import com.example.TravelAgency.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalRequest extends BaseEntity {

    @ManyToOne(optional=false)
    private TravelArrangement arrangement;

    @ManyToOne(optional=false)
    private User requestedBy;

    @ManyToOne
    private User approvedBy;

    @Column(nullable=false)
    private Instant requestedAt = Instant.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private ApprovalDecision decision = ApprovalDecision.PENDING;

    private Instant decidedAt;
    private String comment;
}