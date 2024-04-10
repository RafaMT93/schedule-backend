package com.schedulebackend.service;

import com.schedulebackend.DTO.PhoneDTO;
import com.schedulebackend.model.Phone;
import com.schedulebackend.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Phone getPhoneByGuid(String guid) {
        return phoneRepository.findById(guid)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
    }

    public Phone createPhone(PhoneDTO phoneDTO) {
        Phone phone = new Phone();
        phone.copyFromDTO(phoneDTO);
        return phoneRepository.save(phone);
    }

    public void replacePhone(PhoneDTO phoneDTO) {
        Phone phone = new Phone();
        phone.copyFromDTO(phoneDTO);
        phoneRepository.save(phone);
    }

    public void deletePhone(String guid) {
        phoneRepository.deleteById(guid);
    }
}

