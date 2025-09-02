package com.example.OnlyBuns.repository;

import com.example.OnlyBuns.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
