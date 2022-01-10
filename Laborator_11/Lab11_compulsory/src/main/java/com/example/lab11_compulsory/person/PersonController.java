package com.example.lab11_compulsory.person;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
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
        Person person = personService.personRepository.findById(id);
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
        Person person = personService.personRepository.findById(id);
        if (person== null) {
            return false;
        }else
        {

            personService.personRepository.delete(person);
            return true;
        }
    }
    @PostMapping("/add/friend")
    public boolean addFriend(@RequestParam long id,@RequestParam long friendId){
        Person person=null;
        Person friend=null;
        try{
           person = personService.personRepository.findById(id);
           friend = personService.personRepository.findById(friendId);
        }catch(EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
        if(person==null||friend==null){
            throw new ResourceNotFoundException("One of persons not found!");
        }
        if(person.getFriends().contains(friend)){
            return false;
        }
        person.addFriend(friend);
        personService.personRepository.save(person);
        return true;
    }
    @DeleteMapping("/delete/friend")
    public boolean deleteFriend(@RequestParam long id,@RequestParam long friendId){
        Person person = personService.personRepository.findById(id);
        Person friend = personService.personRepository.findById(friendId);
        if(person==null||friend==null){
            return false;
        }
        if(!person.getFriends().contains(friend)){
            return false;
        }
        person.getFriends().remove(friend);
        personService.personRepository.save(person);
        return true;
    }
    @GetMapping("/get/friends")
    public List<String> getFriends(@RequestParam long id){
        Person person = personService.personRepository.findById(id);
        if (person == null) {
            return null;
        }
        List<String> friends=new ArrayList<>();
        for (Person friend :person.getFriends()) {
            friends.add(friend.getName());
        }
        return friends;
    }
    @GetMapping("/get/populars")
    public List<String> getPopular(@RequestParam int k){
        List<String> populars=new ArrayList<>();
        List<Person> persons=personService.personRepository.findAll();
        persons.sort(Person::compareTo);
        for(int index=0;index<k;index++){
            populars.add(persons.get(index).getName());
        }
        return populars;
    }

}
