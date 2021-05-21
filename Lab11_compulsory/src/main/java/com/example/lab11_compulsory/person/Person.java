package com.example.lab11_compulsory.person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person")
public class Person implements Comparable<Person> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @ManyToMany
    private List<Person> friends=new ArrayList<>();
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }
    public void addFriend(Person person){
        friends.add(person);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(o.getFriends().size(),this.getFriends().size());
    }
}
