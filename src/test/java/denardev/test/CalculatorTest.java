package denardev.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

@DisplayName("Test for calculator class")
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After Each");
    }

    @Test
    @DisplayName("Test for success scenario for method add(Integer, Integer)")
    public void testAddSuccess(){
        var result = calculator.add(1,1);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Test for success scenario for method divide(Integer, Integer)")
    public void testDivideSuccess(){
        var result = calculator.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Test for failed scenario for method divide(Integer, Integer)")
    @Disabled
    public void testDivideFailed(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if(!"DEV".equals(profile)){
            throw new TestAbortedException();
        }else {
            // unit test untuk DEV
        }
    }

    @Test
    public void testAssumption(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));

        // unit test untuk DEV
    }

}
