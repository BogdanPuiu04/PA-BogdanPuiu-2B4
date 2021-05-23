package com.pa.lab11.person;

import com.pa.lab11.person.Person;
import com.pa.lab11.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestService {
    private PersonRepository personRepository;


    @Autowired
    public RestService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public boolean savePerson(Person person) {
        personRepository.save(person);
        return true;
    }
    public Person findByName(String name){
        try {
            return personRepository.findByUsername(name);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public boolean deletePerson(String name){
        Person person=personRepository.findByUsername(name);
        if(person==null)
            return false;
        personRepository.delete(person);
        return true;
    }
    public List<Person> getAll(){
        return personRepository.findAll();
    }
}
