package com.schedulebackend.DTO;

import com.schedulebackend.model.Person;
import com.schedulebackend.model.enums.PhoneType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhoneDTO {
    private String guid;

    private Long number;

    private PhoneType type;

    private Person person;

    public PhoneDTO() {}

    public PhoneDTO(Long number, PhoneType type, Person person) {
        this();
        this.number = number;
        this.type = type;
        this.person = person;
    }

    public PhoneDTO(Long number, PhoneType type, Person person, String guid) {
        this(number, type, person);
        this.guid = guid;
    }

}
