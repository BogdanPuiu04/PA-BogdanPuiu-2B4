package com.pa.lab11.person;

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
    public String addPerson(@RequestParam String name){
        Person person=new Person(name);

       if( restService.savePerson(person))
           return "Succes";
        return "Error: user already existing";
    }


    @PutMapping("update/user")
    public String updatePerson(@RequestParam String name , @RequestParam String updatedName){
        Person person=restService.findByName(name);
        Person aux=restService.findByName(updatedName);
        if(aux==null) {
            person.setUsername(updatedName);
            if(restService.savePerson(person))
                return "Succes";
            return "Error: user not updated";
        }
        return "Error user already exists";
    }
    @DeleteMapping("delete/user")
    public boolean deletePerson(@RequestParam String name){
        Person person=restService.findByName(name);
        if(person==null)
            return false;
        if(restService.deletePerson(name))
        return true;
        return false;
    }

    @GetMapping("get/user")
    public List<Person> getUsers(){
        List<Person> people=new ArrayList<>();
        people=restService.getAll();
        return people;
    }

    public String test(){
        return "test";
    }
}
