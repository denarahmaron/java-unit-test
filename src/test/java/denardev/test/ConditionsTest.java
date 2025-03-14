package denardev.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import javax.crypto.Mac;
import java.util.Properties;

public class ConditionsTest {

    @Test
    public void testSystemProperties(){
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledOnOs(value = {OS.MAC})
    public void testRunOnlyOnMac (){
        //
    }

    @Test
    @DisabledOnOs(value = {OS.MAC})
    public void testDisabledOnMac(){
        //
    }

    @Test
    @EnabledOnJre({JRE.JAVA_23})
    public void testRunOnJava23(){
        //
    }

    @Test
    @DisabledOnJre({JRE.JAVA_23})
    public void testDisabledOnJava23(){
        //
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_10,max = JRE.JAVA_23)
    public void testEnabledOnJavaRange(){
        //
    }

    @Test
    @EnabledIfSystemProperties(
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    )
    public void testEnabledOnJavaVendorOracle(){

    }

    @Test
    @DisabledIfSystemProperties(
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    )
    public void testDisabledOnJavaVendorOracle(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void testEnabledEnv(){

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void testDisabledEnv(){

    }
}
