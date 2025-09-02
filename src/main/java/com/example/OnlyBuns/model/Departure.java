package com.example.OnlyBuns.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Departures")
public class Departure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long departureId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrangement_id", nullable = false)
    private Arrangement arrangement;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "capacity_total", nullable = false)
    private Integer capacityTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DepartureStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
