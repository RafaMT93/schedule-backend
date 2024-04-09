package com.schedulebackend.repository;

import com.schedulebackend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {}
