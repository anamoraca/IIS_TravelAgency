package com.example.OnlyBuns.controller;

import com.example.OnlyBuns.model.Like;
import com.example.OnlyBuns.model.Location;
import com.example.OnlyBuns.service.LikeService;
import com.example.OnlyBuns.service.LocationService;
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
@RequestMapping(value = "/api/likes", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class LikeController {
    @Autowired
    private LikeService likeService;

    @GetMapping("")
    public ResponseEntity<List<Like>> getAll() {
        return new ResponseEntity<>(this.likeService.findAll(), HttpStatus.OK);
    }
}

