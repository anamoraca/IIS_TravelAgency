package com.example.TravelAgency.repository;

import com.example.TravelAgency.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
