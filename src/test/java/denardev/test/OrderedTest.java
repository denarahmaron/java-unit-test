package denardev.test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    public int counter;

    @BeforeAll
    void beforeAll() {

    }

    @AfterAll
    void afterAll() {

    }

    @Test
    @Order(1)
    public void testOrder3(){
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    public void testOrder2(){
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    public void testOrder1(){
        counter++;
        System.out.println(counter);
    }
}
