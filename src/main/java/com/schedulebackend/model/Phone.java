package com.schedulebackend.model;

import com.schedulebackend.DTO.PhoneDTO;
import com.schedulebackend.model.enums.PhoneType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String guid;

    private Long number;

    private PhoneType type;

    public Phone() {}

    public Phone(String guid, Long number, PhoneType type) {
        this.guid = guid;
        this.number = number;
        this.type = type;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(guid, phone.guid) &&
                Objects.equals(number, phone.number) &&
                type == phone.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, number, type);
    }

    public void copyFromDTO(PhoneDTO phoneDTO) {
        this.guid = phoneDTO.getGuid();
        this.number = phoneDTO.getNumber();
        this.type = phoneDTO.getType();
    }
}
