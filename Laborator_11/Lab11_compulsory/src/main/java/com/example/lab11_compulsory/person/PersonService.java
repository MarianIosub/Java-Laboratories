package com.example.lab11_compulsory.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    public PersonRepository personRepository;
    @Autowired

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
