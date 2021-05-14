package com.pa.lab11.person;

import com.pa.lab11.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
        @Query("SELECT x from Person x WHERE x.username=?1")
         Person findByUsername(String username);

}
