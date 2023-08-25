package br.com.java.exploringrestwithspringboot.Controllers;

import br.com.java.exploringrestwithspringboot.VO.v1.PersonVOv1;
import br.com.java.exploringrestwithspringboot.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(value = "/{ID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOv1 findById(@PathVariable(value = "ID") Long ID) {
        return service.findById(ID);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVOv1> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOv1 create(@RequestBody PersonVOv1 person) {
        return service.create(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOv1 update(@RequestBody PersonVOv1 person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{ID}")
    public ResponseEntity<Object> delete(@PathVariable(value = "ID") Long ID) {
        service.delete(ID);
        return ResponseEntity.noContent().build();
    }
}

