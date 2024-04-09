package com.schedulebackend.service;

import com.schedulebackend.DTO.AddressDTO;
import com.schedulebackend.model.Address;
import com.schedulebackend.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressByGuid(String guid) {
        return addressRepository.findById(guid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Address> createAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.copyFromDTO(addressDTO);
        addressRepository.save(address);
        return getAllAddress();
    }

    public void replace(AddressDTO addressDTO) {
        Address address = new Address();
        address.copyFromDTO(addressDTO);
        addressRepository.save(address);
    }

    public void deleteAddressByGuid(String guid) {
        addressRepository.deleteById(guid);
    }
}
