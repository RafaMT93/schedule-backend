package com.schedulebackend.service;

import com.schedulebackend.DTO.AddressDTO;
import com.schedulebackend.DTO.PersonDTO;
import com.schedulebackend.DTO.PhoneDTO;
import com.schedulebackend.model.Person;
import com.schedulebackend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    private final PhoneService phoneService;
    private final AddressService addressService;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonByGuid(String guid) {
        return personRepository.findById(guid)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public Person createPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.copyFromDTO(personDTO);

        setPersonAddress(personDTO, person);
        setPersonPhone(personDTO, person);

        return personRepository.save(person);
    }

    public void setPersonAddress(PersonDTO personDTO, Person person) {
        if(!personDTO.getAddress().isEmpty()) {
            personDTO.getAddress()
                    .forEach((item) -> {
                        AddressDTO addressDTO = new AddressDTO(
                                item.getStreetType(),
                                item.getStreet(),
                                item.getNumber(),
                                item.getCity(),
                                item.getState(),
                                item.getZip(),
                                item.getCountry(),
                                person
                        );
                        addressService.createAddress(addressDTO);
                    });
        }
    }

    public void setPersonPhone(PersonDTO personDTO, Person person) {
        if(!personDTO.getPhone().isEmpty()) {
            personDTO.getPhone()
                    .forEach((item) -> {
                        PhoneDTO phoneDTO = new PhoneDTO(
                                item.getNumber(),
                                item.getType(),
                                person
                        );
                        phoneService.createPhone(phoneDTO);
                    });
        }
    }

    public void replacePerson(PersonDTO personDTO) {
        Person person = new Person();
        person.copyFromDTO(personDTO);
        personRepository.save(person);
    }

    public void deletePerson(String guid) {
        personRepository.deleteById(guid);
    }

    public List<Person> getPersonByName(String name) {
        return personRepository.getPersonByNameContaining(name);
    }
}
