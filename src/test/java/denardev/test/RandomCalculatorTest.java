package denardev.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import resolver.RandomParameterResolver;

import java.util.List;
import java.util.Random;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class RandomCalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void testRandom(Random random){
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a,b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    };

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomRepeat(Random random){
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a,b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    };

    @DisplayName("Test random calculator info")
    @RepeatedTest(value = 10, name = "{displayName}")
    void testRandomRepeatInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo){
        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a,b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    };

    @DisplayName("Test Calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void testWithParameter(int value){
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource(){
        return List.of(1,2,3,4,5,6,7,8,9);
    }


    @DisplayName("Test Calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource("parameterSource")
    void testWithParameterMethod(int value){
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

}
