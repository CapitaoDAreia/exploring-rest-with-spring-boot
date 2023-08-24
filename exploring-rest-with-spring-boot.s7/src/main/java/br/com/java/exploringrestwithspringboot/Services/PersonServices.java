package br.com.java.exploringrestwithspringboot.Services;

import br.com.java.exploringrestwithspringboot.Exceptions.PersonNotFoundException;
import br.com.java.exploringrestwithspringboot.Model.Person;
import br.com.java.exploringrestwithspringboot.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all people");

        return this.repository.findAll();
    }

    public Person findById(Long ID){
        logger.info("Finding person by id: "+ID);

        return this.repository.findById(ID).orElseThrow(()-> new PersonNotFoundException("No records found for this ID: " + ID));
    }

    public Person create(Person person){
        logger.info("Creating person | person name: " + person.getFirstName());
        return this.repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating person | person name: " + person.getFirstName());

        Person entity = this.repository.findById(person.getId()).orElseThrow(()-> new PersonNotFoundException("No records found for this ID: " + person.getId()));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        return this.repository.save(entity);
    }

    public void delete(Long ID){
        logger.info("Deleting person | person ID: " + ID);

        Person entity = this.repository.findById(ID).orElseThrow(()-> new PersonNotFoundException("No records found for this ID: " + ID));

        this.repository.delete(entity);
    }

}
