package com.schedulebackend.DTO;

import com.schedulebackend.model.enums.PhoneType;

public class PhoneDTO {
    private String guid;

    private Long number;

    private PhoneType type;

    public PhoneDTO() {}

    public PhoneDTO(Long number, PhoneType type) {
        this.number = number;
        this.type = type;
    }

    public PhoneDTO(Long number, PhoneType type, String guid) {
        this(number, type);
        this.guid = guid;
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
}
