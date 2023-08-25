package br.com.java.exploringrestwithspringboot.Services;

import br.com.java.exploringrestwithspringboot.Exceptions.PersonNotFoundException;
import br.com.java.exploringrestwithspringboot.Mapper.CustomPersonMapper;
import br.com.java.exploringrestwithspringboot.Mapper.ModelMapper;
import br.com.java.exploringrestwithspringboot.Model.Person;
import br.com.java.exploringrestwithspringboot.VO.v1.PersonVOv1;
import br.com.java.exploringrestwithspringboot.Repositories.PersonRepository;
import br.com.java.exploringrestwithspringboot.VO.v2.PersonVOv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    CustomPersonMapper mapper;

    public List<PersonVOv1> findAll() {
        logger.info("Finding all people");

        List<Person> entities = this.repository.findAll();

        return ModelMapper.parseListObjects(entities, PersonVOv1.class);
    }

    public PersonVOv1 findById(Long ID) {
        logger.info("Finding person by id: " + ID);

        Person entity = this.repository.findById(ID).orElseThrow(() -> new PersonNotFoundException("No records found for this ID: " + ID));

        return ModelMapper.parseObject(entity, PersonVOv1.class);
    }

    public PersonVOv1 create(PersonVOv1 person) {
        logger.info("Creating person | person name: " + person.getFirstName());

        Person entity = ModelMapper.parseObject(person, Person.class);

        Person savedEntity = this.repository.save(entity);

        return ModelMapper.parseObject(savedEntity, PersonVOv1.class);
    }

    public PersonVOv2 createV2(PersonVOv2 person) {
        logger.info("Creating person | person name: " + person.getFirstName());

        Person entity = mapper.convertVoToEntity(person);

        Person savedEntity = this.repository.save(entity);

        return mapper.convertEntityToVo(savedEntity);
    }

    public PersonVOv1 update(PersonVOv1 person) {
        logger.info("Updating person | person name: " + person.getFirstName());

        Person entity = this.repository.findById(person.getId()).orElseThrow(() -> new PersonNotFoundException("No records found for this ID: " + person.getId()));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        Person savedPerson = this.repository.save(entity);

        return ModelMapper.parseObject(savedPerson, PersonVOv1.class);
    }

    public void delete(Long ID) {
        logger.info("Deleting person | person ID: " + ID);

        Person entity = this.repository.findById(ID).orElseThrow(() -> new PersonNotFoundException("No records found for this ID: " + ID));

        this.repository.delete(entity);
    }

}
