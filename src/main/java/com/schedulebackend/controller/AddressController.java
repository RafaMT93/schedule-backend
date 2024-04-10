package com.schedulebackend.controller;

import com.schedulebackend.DTO.AddressDTO;
import com.schedulebackend.model.Address;
import com.schedulebackend.service.AddressService;
import com.schedulebackend.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("address")
@Log4j2
@RequiredArgsConstructor
public class AddressController {
    private final DateUtil dateUtil;
    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @GetMapping(path = "/{guid}")
    public ResponseEntity<Address> getAddressByGuid(@PathVariable String guid) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        try {
            return ResponseEntity.ok(addressService.getAddressByGuid(guid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody AddressDTO addressDTO) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(addressService.createAddress(addressDTO));
    }

    @DeleteMapping(path = "/{guid}")
    public ResponseEntity<Void> deleteAddress(@PathVariable String guid) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        addressService.deleteAddressByGuid(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> updateAddress(@RequestBody AddressDTO addressDTO) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        try {
            Address find = addressService.getAddressByGuid(addressDTO.getGuid());
            if (find == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            addressService.replace(addressDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
