package denardev.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration-test")
public class SampleIntegrationTest {
    @Test
    public void integrationTest1(){
        System.out.println("Integration Test1");
    }

    @Test
    public void integrationTest2(){
        System.out.println("Integration Test2");
    }
}
