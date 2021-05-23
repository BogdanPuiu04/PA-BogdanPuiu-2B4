package com.pa.lab11.person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person implements Comparable<Person>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String username;


    @OneToMany
    List<Person> personList=new ArrayList<>();

    public Person(String username) {
        this.username=username;
    }

    public Person() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Person> getPersonList() {
        return personList;
    }
    public void addFriend(Person p){
        personList.add(p);
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
       return Integer.compare(o.getPersonList().size(),this.getPersonList().size());
    }
}
