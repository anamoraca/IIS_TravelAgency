package com.example.TravelAgency.repository;

import com.example.TravelAgency.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
