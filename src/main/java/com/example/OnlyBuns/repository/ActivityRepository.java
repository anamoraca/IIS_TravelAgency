package com.example.OnlyBuns.repository;

import com.example.OnlyBuns.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
