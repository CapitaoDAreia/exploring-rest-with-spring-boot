package br.com.java.exploringrestwithspringboot.Controllers;

import br.com.java.exploringrestwithspringboot.Services.PersonServices;
import br.com.java.exploringrestwithspringboot.VO.v2.PersonVOv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person/v2")
public class PersonControllerV2 {

    @Autowired
    private PersonServices service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOv2 createV2(@RequestBody PersonVOv2 person) {
        return service.createV2(person);
    }
}
