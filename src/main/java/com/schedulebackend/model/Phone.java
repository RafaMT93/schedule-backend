package com.schedulebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.schedulebackend.DTO.PhoneDTO;
import com.schedulebackend.model.enums.PhoneType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "TB_PHONE")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "phone_guid")
    private String guid;

    private Long number;

    private PhoneType type;

    @ManyToOne
    @JoinColumn(name = "person_guid")
    @JsonIgnore
    private Person person;

    public Phone() {}

    public Phone(String guid, Long number, PhoneType type) {
        this.guid = guid;
        this.number = number;
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
        this.person = phoneDTO.getPerson();
    }
}
