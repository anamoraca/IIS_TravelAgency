package com.example.TravelAgency.repository;

import com.example.TravelAgency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    Boolean existsByEmail(String email);

    Optional<User> findByActivationToken(String token);
}
