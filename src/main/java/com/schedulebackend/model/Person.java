package com.schedulebackend.model;

import com.schedulebackend.model.enums.Genre;

import java.util.List;

public class Person {

    private String guid;

    private String name;

    private Genre genre;

    private Integer age;

    private List<Phone> phone;

    private Address address;

    public Person() {}

    public Person(String guid, String name, Genre genre, Integer age, List<Phone> phone) {
        this.guid = guid;
        this.name = name;
        this.genre = genre;
        this.age = age;
        this.phone = phone;
    }

    public String getGuid() {
        return guid;
    };

    public void setGuid(String guid) {
        this.guid = guid;
    };

    public String getName() {
        return name;
    };

    public void setName(String name) {
        this.name = name;
    };

    public Genre getGenre() {
        return genre;
    };

    public void setGenre(Genre genre) {
        this.genre = genre;
    };

    public Integer getAge() {
        return age;
    };

    public void setAge(Integer age) {
        this.age = age;
    };

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
