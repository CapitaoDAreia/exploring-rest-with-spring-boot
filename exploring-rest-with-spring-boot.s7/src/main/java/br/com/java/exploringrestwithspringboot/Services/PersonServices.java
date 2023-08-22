package br.com.java.exploringrestwithspringboot.Services;

import br.com.java.exploringrestwithspringboot.Model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

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

}
