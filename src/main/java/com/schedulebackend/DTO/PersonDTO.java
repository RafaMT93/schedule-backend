package com.schedulebackend.DTO;

import com.schedulebackend.model.Address;
import com.schedulebackend.model.Phone;
import com.schedulebackend.model.enums.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PersonDTO {
    private String guid;

    private String name;

    private Genre genre;

    private Integer age;

    private List<Phone> phone;

    private List<Address> address;

    public PersonDTO() {}

    public PersonDTO(String name, Genre genre, Integer age) {
        this();
        this.name = name;
        this.genre = genre;
        this.age = age;
    }

    public PersonDTO(String name, Genre genre, Integer age, String guid) {
        this(name, genre, age);
        this.guid = guid;
    }

    public PersonDTO(String name, Genre genre, Integer age, String guid, List<Phone> phone, List<Address> address) {
        this(name, genre, age, guid);
        this.phone = phone;
        this.address = address;
    }

}
