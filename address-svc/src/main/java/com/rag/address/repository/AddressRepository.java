package com.rag.address.repository;

import com.rag.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findAddressByZipCode(String zipCode);
}
