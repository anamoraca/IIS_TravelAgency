package com.example.TravelAgency.arrangements.model;

import com.example.TravelAgency.model.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "destination")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Destination extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", nullable = false) // FK ka Country
    private Country country;

    @Column(nullable = false)
    private String name;

    @Column(length = 2048)
    private String description;

    @Column(nullable = false)
    private boolean active = true;

    @ManyToOne(optional = false)
    @JoinColumn(name = "created_by", nullable = false) // FK ka User
    private User createdBy;
}
