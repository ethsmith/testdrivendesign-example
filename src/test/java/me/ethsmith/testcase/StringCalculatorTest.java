package me.ethsmith.testcase;

import me.ethsmith.tdd.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringCalculatorTest {

    /*
            Step 1
            The method can take up to two numbers, separated by commas, and will return their sum.
            for example “” or “1” or “1,2” as inputs.
            (for an empty string it will return 0)
    */
    @ParameterizedTest()
    @MethodSource("stepOneArgs")
    public void GivenTwoNumbersWhenRanThenCalculateSum(String input, int expected) {
        // Arrange
        Calculator cal = new Calculator();

        // Act
        int result = cal.Add(input);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    /*
            Step 2
            Allow the Add method to handle an unknown amount of numbers
     */
    @ParameterizedTest()
    @MethodSource("stepTwoArgs")
    public void GivenAnyAmountNumbersWhenRanThenCalculateSum(String input, int expected) {
        // Arrange
        Calculator cal = new Calculator();

        // Act
        int result = cal.Add(input);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    /*
            Step 3
            Allow the Add method to handle new lines between numbers (instead of commas).

            the following input is ok: “1\n2,3” (will equal 6)
            the following input is NOT ok: “1,\n” (not need to prove it - just clarifying)
     */
    @ParameterizedTest()
    @MethodSource("stepThreeArgs")
    public void GivenANewLineSplitWhenRanThenCalculateSum(String input, int expected) {
        // Arrange
        Calculator cal = new Calculator();

        // Act
        int result = cal.Add(input);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    /*
            Step 4
            Support different delimiters to change a delimiter, the beginning of the string will contain a separate line that looks like this:
            “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
            the first line is optional. all existing scenarios should still be supported
     */
    @ParameterizedTest()
    @MethodSource("stepFourArgs")
    public void GivenTwoSlashesChangeDelimiterWhenRanThenCalculateSum(String input, int expected) {
        // Arrange
        Calculator cal = new Calculator();

        // Act
        int result = cal.Add(input);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> stepOneArgs() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1", 1),
                Arguments.of("1,2", 3)
        );
    }

    private static Stream<Arguments> stepTwoArgs() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("10,90,10,20", 130)
        );
    }

    private static Stream<Arguments> stepThreeArgs() {
        return Stream.of(
                Arguments.of("1\n2,3", 6),
                Arguments.of("10,90\n10,20", 130)
        );
    }

    private static Stream<Arguments> stepFourArgs() {
        return Stream.of(Arguments.of("//;\n1;2", 3));
    }
}
