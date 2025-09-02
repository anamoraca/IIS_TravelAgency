package com.example.OnlyBuns.repository;

import com.example.OnlyBuns.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
