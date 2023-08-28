package unitTests.mockito.services;

import br.com.java.exploringrestwithspringboot.Model.Person;
import br.com.java.exploringrestwithspringboot.Repositories.PersonRepository;
import br.com.java.exploringrestwithspringboot.Services.PersonServices;
import br.com.java.exploringrestwithspringboot.VO.v1.PersonVOv1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import unitTests.mocks.MockPerson;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices services;

    @Mock
    PersonRepository personRepository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        fail("Not yet implemented");

    }

    @Test
    void testFindById() {
        Person person = input.mockEntity(1);

        when(personRepository.findById(1L))
                .thenReturn(Optional.of(person));

        PersonVOv1 entity = services.findById(1L);

        assertNotNull(entity);
        assertNotNull(entity.getKey());
        assertNotNull(entity.getLinks());
        assertTrue(entity.toString().contains("</api/person/v1/1>;rel=\"self\""));

        assertEquals(person.getAddress(), entity.getAddress());
        assertEquals(person.getFirstName(), entity.getFirstName());
        assertEquals(person.getLastName(), entity.getLastName());
        assertEquals(person.getGender(), entity.getGender());
    }

    @Test
    void testCreate() {
        fail("Not yet implemented");
    }

    @Test
    void testCreateV2() {
        fail("Not yet implemented");
    }

    @Test
    void testUpdate() {
        fail("Not yet implemented");
    }

    @Test
    void testDelete() {
        fail("Not yet implemented");
    }

}
