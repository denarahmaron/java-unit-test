package denardev.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    @Test
    @Order(1)
    public void testOrder3(){

    }

    @Test
    @Order(2)
    public void testOrder2(){

    }

    @Test
    @Order(3)
    public void testOrder1(){

    }
}
