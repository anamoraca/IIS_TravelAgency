package com.example.OnlyBuns.repository;

import com.example.OnlyBuns.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    Boolean existsByEmail(String email);

    Optional<User> findByActivationToken(String token);
}
