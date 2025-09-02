package com.example.OnlyBuns.controller;

import com.example.OnlyBuns.model.Location;
import com.example.OnlyBuns.model.User;
import com.example.OnlyBuns.service.LocationService;
import com.example.OnlyBuns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/locations", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("")
    public ResponseEntity<List<Location>> getAll() {
        return new ResponseEntity<>(this.locationService.findAll(), HttpStatus.OK);
    }
}
