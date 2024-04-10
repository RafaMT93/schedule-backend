package com.schedulebackend.model;

import com.schedulebackend.DTO.PersonDTO;
import com.schedulebackend.model.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "TB_PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "person_guid")
    private String guid;

    private String name;

    private Genre genre;

    private Integer age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Phone> phone;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> address;

    public Person() {}

    public Person(String guid, String name, Genre genre, Integer age, List<Phone> phone, List<Address> address) {
        this.guid = guid;
        this.name = name;
        this.genre = genre;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    ;;;;;;;;

    public void copyFromDTO(PersonDTO personDTO) {
        this.guid = personDTO.getGuid();
        this.name = personDTO.getName();
        this.genre = personDTO.getGenre();
        this.age = personDTO.getAge();
    }
}
