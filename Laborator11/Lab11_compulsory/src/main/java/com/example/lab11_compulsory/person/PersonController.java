package com.example.lab11_compulsory.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/get/person")
    public List<Person> getPersons() {
        return personService.personRepository.findAll();
    }

    @PostMapping("/add/person")
    public boolean addPerson(@RequestParam String name) {
        Person person = personService.personRepository.findByName(name);
        if (person != null) {
            return false;
        }
        person = new Person(name);
        personService.personRepository.save(person);
        return true;
    }

    @PutMapping("/update/person")
    public boolean updatePerson(@RequestParam long id, @RequestParam String name) {
        Person person = personService.personRepository.getOne(id);
        if (person == null) {
            return false;
        } else {
            person.setName(name);
            personService.personRepository.save(person);
            return true;
        }
    }
    @DeleteMapping("/delete/person")
    public boolean deletePerson(@RequestParam long id){
        Person person = personService.personRepository.getOne(id);
        if (person == null) {
            return false;
        }else
        {
            personService.personRepository.delete(person);
            return true;
        }
    }

}
