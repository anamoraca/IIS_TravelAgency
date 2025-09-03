package com.example.TravelAgency.service;

import com.example.TravelAgency.model.Location;
import com.example.TravelAgency.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location findById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }


    public List<Location> findAll() {
        return locationRepository.findAll();
    }
    public List<Location> findAllById(List<Long> ids) {
        return locationRepository.findAllById(ids);
    }
}
