package com.rag.customer.service;

import com.rag.customer.data.Passport;
import com.rag.customer.data.Person;
import com.rag.customer.repository.PassportRepository;
import com.rag.customer.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;

    @PostConstruct
    public void createPersonWithPassport() {
        // Create a new Person
        Person person = new Person();
        person.setName("John Doe");

        // Create a new Passport
        Passport passport = new Passport();
        passport.setNumber("123456789");

        // Link the Passport to the Person
        person.setPassport(passport);  // Set the passport for the person
        passport.setPerson(person);    // Set the person for the passport

        // Save the person (passport will be saved automatically due to CascadeType.ALL)
        personRepository.save(person);
    }
}
