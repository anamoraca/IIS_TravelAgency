package com.example.TravelAgency.arrangements.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country extends BaseEntity {
    @Column(nullable=false, unique=true)
    private String name;
}