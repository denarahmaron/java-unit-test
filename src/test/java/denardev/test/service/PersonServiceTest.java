package denardev.test.service;

import denardev.test.data.Person;
import denardev.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp(){
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess(){
        // add behaviour to mock object
        Mockito.when(personRepository.selectByID("denar"))
                .thenReturn(new Person("denar", "Denar"));

        var person = personService.get("denar");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("denar", person.getId());
        Assertions.assertEquals("Denar", person.getName());
    }

    @Test
    void testRegisterSuccess(){
        var person = personService.register("denar");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("denar", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "denar"));
    }
}
