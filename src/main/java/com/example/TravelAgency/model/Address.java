package com.example.TravelAgency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", nullable = false)
    @NotBlank(message = "Country is required")
    private String country;

    @Column(name = "city", nullable = false)
    @NotBlank(message = "City is required")
    private String city;

    @Column(name = "zip_code", nullable = false)
    @NotNull(message = "Zip code is required")
    private int zipCode;

    @Column(name = "street_address", nullable = false)
    @NotBlank(message = "Street address is required")
    private String streetAddress;
}
