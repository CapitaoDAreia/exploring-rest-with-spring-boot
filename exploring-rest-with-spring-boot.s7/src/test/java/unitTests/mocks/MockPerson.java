package unitTests.mocks;

import br.com.java.exploringrestwithspringboot.Model.Person;
import br.com.java.exploringrestwithspringboot.VO.v1.PersonVOv1;
import br.com.java.exploringrestwithspringboot.VO.v2.PersonVOv2;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity(Integer number){
        Person person = new Person();

        person.setFirstName("Test First Name " + number);
        person.setLastName("Test Last Name " + number);
        person.setAddress("Test Address " + number);
        person.setGender("Test Gender " + number);
        person.setId(number.longValue());

        return person;
    }

    public PersonVOv1 mockVOv1(Integer number){
        PersonVOv1 person = new PersonVOv1();

        person.setFirstName("Test First Name " + number);
        person.setLastName("Test Last Name " + number);
        person.setAddress("Test Address " + number);
        person.setGender("Test Gender " + number);
        person.setKey(number.longValue());

        return person;
    }

    public PersonVOv2 mockVOv2(Integer number){
        PersonVOv2 person = new PersonVOv2();

        person.setFirstName("Test First Name " + number);
        person.setLastName("Test Last Name " + number);
        person.setAddress("Test Address " + number);
        person.setGender("Test Gender " + number);
        person.setId(number.longValue());

        return person;
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVOv1> mockVOv1List() {
        List<PersonVOv1> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVOv1(i));
        }
        return persons;
    }

    public List<PersonVOv2> mockVOv2List() {
        List<PersonVOv2> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVOv2(i));
        }
        return persons;
    }

    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVOv1 mockVOv1() {
        return mockVOv1(0);
    }

    public PersonVOv2 mockVOv2() {
        return mockVOv2(0);
    }

}
