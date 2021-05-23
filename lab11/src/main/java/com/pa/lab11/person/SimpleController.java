package com.pa.lab11.person;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SimpleController {

    public RestService restService;

    @Autowired
    public SimpleController(RestService restService) {
        this.restService = restService;
    }

    @PostMapping("add/user")
    public String addPerson(@RequestParam String name) {
        Person person = new Person(name);

        if (restService.savePerson(person))
            return "Succes";
        return "Error: user already existing";
    }


    @PutMapping("update/user")
    public String updatePerson(@RequestParam String name, @RequestParam String updatedName) {
        Person person = restService.findByName(name);
        Person aux = restService.findByName(updatedName);
        if (aux == null) {
            person.setUsername(updatedName);
            if (restService.savePerson(person))
                return "Succes";
            return "Error: user not updated";
        }
        return "Error user already exists";
    }

    @DeleteMapping("delete/user")
    public boolean deletePerson(@RequestParam String name) {
        Person person = restService.findByName(name);
        if (person == null)
            return false;
        if (restService.deletePerson(name))
            return true;
        return false;
    }

    @GetMapping("get/user")
    public List<Person> getUsers() {
        List<Person> people = new ArrayList<>();
        people = restService.getAll();
        return people;
    }

    @GetMapping("get/friends")
    public List<Person> getFriends(@RequestParam String name) {
        Person person = restService.findByName(name);
        if (person == null)
            return null;
        List<Person> aux=person.getPersonList();
        System.out.println(aux);
        return aux;
    }

    @PutMapping("insert/friend")
    public boolean insertFriend(@RequestParam String name, @RequestParam String friend) {
        Person person = restService.findByName(name);
        if (person == null)
            throw new ResourceNotFoundException("first user not found");
        Person person1 = restService.findByName(friend);
        if (person1 == null)
            return false;
        if (person.getPersonList().contains(person1))
            return false;
        person.addFriend(person1);
        person1.addFriend(person);
        System.out.println(person.getPersonList());
        System.out.println(person1.getPersonList());
        restService.savePerson(person);
        restService.savePerson(person1);
        return true;
    }

    @GetMapping("popular/user")
    public List<Person> getPopularUsers(@RequestParam int k){
        List<Person> personList=restService.getAll();
        personList.sort(Person::compareTo);
        List<Person> aux=new ArrayList<>();
        if(personList.size()<k)
            k=personList.size();
        for(int i=0;i<k;i++)
            aux.add(personList.get(i));
        return aux;
    }

    public String test() {
        return "test";
    }
}
