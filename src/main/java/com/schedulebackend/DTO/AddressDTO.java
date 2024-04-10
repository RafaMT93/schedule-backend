package com.schedulebackend.DTO;

import com.schedulebackend.model.Person;
import com.schedulebackend.model.enums.StreetType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDTO {
    private String guid;

    private StreetType streetType;

    private String street;

    private Integer number;

    private String city;

    private String state;

    private String zip;

    private String country;

    private Person person;

    public AddressDTO() {}

    public AddressDTO(StreetType streetType, String street, Integer number, String city, String state, String zip, String country, Person person) {
        this();
        this.streetType = streetType;
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.person = person;
    }

    public AddressDTO(StreetType streetType, String street, Integer number, String city, String state, String zip, String country, Person person, String guid) {
        this(streetType, street, number, city, state, zip, country, person);
        this.guid = guid;
    }

}
