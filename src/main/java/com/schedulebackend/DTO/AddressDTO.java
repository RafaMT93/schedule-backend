package com.schedulebackend.DTO;

import com.schedulebackend.model.enums.StreetType;

public class AddressDTO {
    private String guid;

    private StreetType streetType;

    private String street;

    private Integer number;

    private String city;

    private String state;

    private String zip;

    private String country;

    public AddressDTO() {}

    public AddressDTO(StreetType streetType, String street, Integer number, String city, String state, String zip, String country) {
        this.streetType = streetType;
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public AddressDTO(StreetType streetType, String street, Integer number, String city, String state, String zip, String country, String guid) {
        this(streetType, street, number, city, state, zip, country);
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public StreetType getStreetType() {
        return streetType;
    }

    public void setStreetType(StreetType streetType) {
        this.streetType = streetType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
