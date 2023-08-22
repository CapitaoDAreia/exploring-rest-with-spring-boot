package br.com.java.exploringrestwithspringboot.Services;

import br.com.java.exploringrestwithspringboot.Model.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all people");

        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String ID){
        logger.info("Finding person by id: "+ID);

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Igor");
        person.setLastName("Silva");
        person.setAddress("São Paulo");
        person.setGender("Male");

        return person;
    }

    private @NotNull Person mockPerson(int i) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Name " + i);
        person.setLastName("Surname " + i);
        person.setAddress("São Paulo " + i);
        person.setGender(i % 2 == 0 ? "Male" : "Female");

        return person;
    }

}
