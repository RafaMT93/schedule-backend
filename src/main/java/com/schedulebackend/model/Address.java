package com.schedulebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.schedulebackend.DTO.AddressDTO;
import com.schedulebackend.model.enums.StreetType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "TB_ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "address_guid")
    private String guid;

    private StreetType streetType;

    private String street;

    private Integer number;

    private String city;

    private String state;

    private String zip;

    private String country;

    @ManyToOne
    @JoinColumn(name = "person_guid")
    @JsonIgnore
    private Person person;

    public Address(){}

    public Address(String guid, StreetType streetType, String street, Integer number, String city, String state, String zip, String country){
        this.guid = guid;
        this.streetType = streetType;
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(guid, address.guid) &&
                streetType == address.streetType &&
                Objects.equals(street, address.street) &&
                Objects.equals(number, address.number) &&
                Objects.equals(city, address.city) &&
                Objects.equals(state, address.state) &&
                Objects.equals(zip, address.zip) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, streetType, street, number, city, state, zip, country);
    }

    public void copyFromDTO(AddressDTO dto){
        this.guid = dto.getGuid();
        this.streetType = dto.getStreetType();
        this.street = dto.getStreet();
        this.number = dto.getNumber();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.zip = dto.getZip();
        this.country = dto.getCountry();
        this.person = dto.getPerson();
    }
}
