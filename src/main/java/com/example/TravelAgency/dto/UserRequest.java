package com.example.TravelAgency.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private Long id;

    private String username;

    private String password;

    private String firstname;

    private String lastname;

    private String email;

    private String country;
    private String city;
    private int zipCode;
    private String streetAddress;


}
