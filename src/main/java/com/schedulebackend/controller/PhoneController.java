package com.schedulebackend.controller;

import com.schedulebackend.DTO.PhoneDTO;
import com.schedulebackend.model.Phone;
import com.schedulebackend.service.PhoneService;
import com.schedulebackend.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("phone")
@Log4j2
@RequiredArgsConstructor
public class PhoneController {
    private final DateUtil dateUtil;
    private final PhoneService phoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhones() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(phoneService.getAllPhones());
    }

    @GetMapping(path = "/{guid}")
    public ResponseEntity<Phone> getPhone(@PathVariable String guid) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(phoneService.getPhoneByGuid(guid));
    }

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody PhoneDTO phoneDTO) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(phoneService.createPhone(phoneDTO));
    }

    @DeleteMapping
    private ResponseEntity<Void> deletePhone(@RequestBody String string) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        phoneService.deletePhone(string);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    private ResponseEntity<Void> updatePhone(@RequestBody PhoneDTO phoneDTO) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        phoneService.replacePhone(phoneDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
