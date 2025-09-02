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
@Table(name = "Bookings")
public class ArrangementBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "traveler_id", nullable = false)
    private User traveler;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departure_id")
    private Departure departure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "promo_id", nullable = false)
    private PromoRule promo;

    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @Column(name = "travelers_count", nullable = false)
    private Integer travelersCount;

    @Column(name = "base_price_at_booking", nullable = false)
    private Double basePriceAtBooking;

    @Column(name = "discount_percent_applied")
    private Double discountPercentApplied;

    @Column(name = "grand_total", nullable = false)
    private Double grandTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus status;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;

    @Column(name = "cancel_reason")
    private String cancelReason;

    @Column(name = "pets", nullable = false)
    private Boolean pets;

    @Column(name = "adventurous", nullable = false)
    private Boolean adventurous;

    @Column(name = "business", nullable = false)
    private Boolean business;
}
