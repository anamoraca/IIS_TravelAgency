package com.example.TravelAgency.arrangements.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@Getter @Setter

public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable=false, updatable=false)
    protected Instant createdAt = Instant.now();

    @Column(nullable=false)
    protected Instant updatedAt = Instant.now();
    @PreUpdate void touch(){ this.updatedAt = Instant.now(); }
}