package com.schedulebackend.repository;

import com.schedulebackend.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String> {}
