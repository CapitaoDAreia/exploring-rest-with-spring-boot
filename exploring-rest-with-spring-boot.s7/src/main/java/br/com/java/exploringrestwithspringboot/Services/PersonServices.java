package br.com.java.exploringrestwithspringboot.Services;

import br.com.java.exploringrestwithspringboot.Exceptions.PersonNotFoundException;
import br.com.java.exploringrestwithspringboot.Mapper.DozerMapper;
import br.com.java.exploringrestwithspringboot.Model.Person;
import br.com.java.exploringrestwithspringboot.v1VO.PersonVO;
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

    public List<PersonVO> findAll(){
        logger.info("Finding all people");

        List<Person> entities = this.repository.findAll();

        return DozerMapper.parseListObjects(entities, PersonVO.class);
    }

    public PersonVO findById(Long ID){
        logger.info("Finding person by id: "+ID);

        Person entity = this.repository.findById(ID).orElseThrow(()-> new PersonNotFoundException("No records found for this ID: " + ID));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        logger.info("Creating person | person name: " + person.getFirstName());

        Person entity = DozerMapper.parseObject(person, Person.class);

        Person savedEntity = this.repository.save(entity);

        return DozerMapper.parseObject(savedEntity, PersonVO.class);
    }

    public PersonVO update(PersonVO person){
        logger.info("Updating person | person name: " + person.getFirstName());

        Person entity = this.repository.findById(person.getId()).orElseThrow(()-> new PersonNotFoundException("No records found for this ID: " + person.getId()));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        Person savedPerson = this.repository.save(entity);

        return DozerMapper.parseObject(savedPerson, PersonVO.class);
    }

    public void delete(Long ID){
        logger.info("Deleting person | person ID: " + ID);

        Person entity = this.repository.findById(ID).orElseThrow(()-> new PersonNotFoundException("No records found for this ID: " + ID));

        this.repository.delete(entity);
    }

}
