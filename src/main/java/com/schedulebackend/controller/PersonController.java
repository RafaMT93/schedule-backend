package com.schedulebackend.controller;

import com.schedulebackend.DTO.PersonDTO;
import com.schedulebackend.model.Person;
import com.schedulebackend.service.PersonService;
import com.schedulebackend.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("person")
@Log4j2
@RequiredArgsConstructor
public class PersonController {
    private final DateUtil dateUtil;
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping(path = "/{guid}")
    public ResponseEntity<Person> getPerson(@PathVariable String guid) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        try {
            return ResponseEntity.ok(personService.getPersonByGuid(guid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Person>> getPersonByName(@RequestParam(name = "name", required = false) String name) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        try {
            return ResponseEntity.ok(personService.getPersonByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody PersonDTO personDTO) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        Person person = personService.createPerson(personDTO);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping(path = "/{guid}")
    public ResponseEntity<Person> deletePerson(@PathVariable String guid) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        personService.deletePerson(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> updatePerson(@RequestBody PersonDTO personDTO) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        try {
            Person find = personService.getPersonByGuid(personDTO.getGuid());

            if (find == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            personService.replacePerson(personDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
