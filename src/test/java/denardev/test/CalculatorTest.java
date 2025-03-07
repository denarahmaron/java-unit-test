package denardev.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test for calculator class")
public class CalculatorTest {
    private Calculator calculator = new Calculator();

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
    public void testDivideFailed(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}
