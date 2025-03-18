package denardev.test;

import org.junit.jupiter.api.*;

@DisplayName("Test with info")
public class InformationTest {


    @Test
    @Tags({
            @Tag("one"),
            @Tag("Two")
    })
    @DisplayName("This is first test")
    public void test(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestMethod());
        System.out.println(testInfo.getTestClass());
    }
}
