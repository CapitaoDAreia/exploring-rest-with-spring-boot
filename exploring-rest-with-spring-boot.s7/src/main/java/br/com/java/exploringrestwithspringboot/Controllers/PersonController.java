package br.com.java.exploringrestwithspringboot.Controllers;

import br.com.java.exploringrestwithspringboot.Model.Person;
import br.com.java.exploringrestwithspringboot.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(value = "/{ID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById( @PathVariable(value = "ID") Long ID ){
        return service.findById(ID);
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return service.findAll();
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create( @RequestBody Person person ){
        return service.create(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update( @RequestBody Person person ){
        return service.update(person);
    }

    @DeleteMapping(value = "/{ID}")
    public ResponseEntity<Object> delete(@PathVariable(value = "ID") Long ID ){
        service.delete(ID);
        return ResponseEntity.noContent().build();
    }
}
