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
        if(personRepository.findByUsername(person.getUsername())!=null)
            return false;
        personRepository.save(person);
        return true;
    }
    public Person findByName(String name){
        return personRepository.findByUsername(name);
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
