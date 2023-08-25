package br.com.java.exploringrestwithspringboot.Mapper;

import br.com.java.exploringrestwithspringboot.Model.Person;
import br.com.java.exploringrestwithspringboot.VO.v2.PersonVOv2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomPersonMapper {
    public PersonVOv2 convertEntityToVo(Person person){
        PersonVOv2 vo = new PersonVOv2();

        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthday(new Date());
        vo.setGender(person.getGender());
        vo.setLastName(person.getLastName());
        vo.setFirstName(person.getFirstName());

        return vo;
    }

    public Person convertVoToEntity(PersonVOv2 person){
        Person entity = new Person();

        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
//        vo.setBirthday(new Date());
        entity.setGender(person.getGender());
        entity.setLastName(person.getLastName());
        entity.setFirstName(person.getFirstName());

        return entity;
    }
}
