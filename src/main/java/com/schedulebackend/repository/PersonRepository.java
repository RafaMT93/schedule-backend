package com.schedulebackend.repository;

import com.schedulebackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    List<Person> getPersonByNameContaining(String name);
}
