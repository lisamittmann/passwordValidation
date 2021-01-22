import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class PasswordValidationTest {


    @ParameterizedTest(name="Single Password {1} meets all criteria: {0}")
    @MethodSource("multiplePasswords")
    public void testValidateMultiplePasswordS(boolean[] expectedResult, String[] passwords) {

        assertTrue(Arrays.equals(expectedResult, PasswordValidation.validateMultiplePassWords(passwords)));
    }

    static Stream<Arguments> multiplePasswords(){
        boolean[] expectedValues = new boolean[5];
        expectedValues[0] = false;
        expectedValues[1] = false;
        expectedValues[2] = false;
        expectedValues[3] = true;
        expectedValues[4] = true;

        String[] passwords = new String[5];
        passwords[0] = "Cookies";
        passwords[1] = "ghhjagn89hhj";
        passwords[2] = "BBHDGLLNNGTT890";
        passwords[3] = "long89Password";
        passwords[4] = "67extra5stRong";

        return Stream.of(
                arguments(expectedValues, passwords)
        );
    }

    @ParameterizedTest(name="Single Password {1} meets all criteria: {0}")
    @MethodSource("password")
    public void testValidatePassword(boolean expectedResult, String password) {

        assertEquals(expectedResult, PasswordValidation.validatePassword(password));
    }

    static Stream<Arguments> password(){
        return Stream.of(
                arguments(false, "Cookies"),
                arguments(false, "longPassword"),
                arguments(false, "ghhjagn89hhj"),
                arguments(false, "BBHDGLLNNGTT890"),
                arguments(true, "long89Password"),
                arguments(true, "67extra5stRong")
        );
    }

    @ParameterizedTest(name="Password {1} is long enough: {0}")
    @MethodSource("passwordLongEnough")
    public void testCheckIfLongEnough(boolean expectedResult, String password) {

        assertEquals(expectedResult, PasswordValidation.checkIfLongEnough(password));
    }

    static Stream<Arguments> passwordLongEnough(){
        return Stream.of(
                arguments(false, "Cookies"),
                arguments(true, "longPassword"),
                arguments(true, "ghhjagn89hhj"),
                arguments(true, "BBHDGLLNNGTT890"),
                arguments(true, "long89Password"),
                arguments(true, "67extra5stRong")
        );
    }

    @ParameterizedTest(name="Password {1} contains numbers: {0}")
    @MethodSource("passwordContainsNumbers")
    public void testCheckIfContainsNumbers(boolean expectedResult, String password) {

        assertEquals(expectedResult, PasswordValidation.checkIfContainsNumbers(password));
    }

    static Stream<Arguments> passwordContainsNumbers(){
        return Stream.of(
                arguments(false, "Cookies"),
                arguments(false, "longPassword"),
                arguments(true, "ghhjagn89hhj"),
                arguments(true, "BBHDGLLNNGTT890"),
                arguments(true, "long89Password"),
                arguments(true, "67extra5stRong")
        );
    }

    @ParameterizedTest(name="Password {1} contains lower case: {0}")
    @MethodSource("passwordContainsLowerCase")
    public void testCheckIfContainsLowerCase(boolean expectedResult, String password) {

        assertEquals(expectedResult, PasswordValidation.checkIfContainsLowerCase(password));
    }

    static Stream<Arguments> passwordContainsLowerCase(){
        return Stream.of(
                arguments(true, "Cookies"),
                arguments(true, "longPassword"),
                arguments(true, "ghhjagn89hhj"),
                arguments(false, "BBHDGLLNNGTT890"),
                arguments(true, "long89Password"),
                arguments(true, "67extra5stRong")
        );
    }

    @ParameterizedTest(name="Password {1} contains upper case: {0}")
    @MethodSource("passwordContainsUpperCase")
    public void testCheckIfContainsUpperCase(boolean expectedResult, String password) {

        assertEquals(expectedResult, PasswordValidation.checkIfContainsUpperCase(password));
    }

    static Stream<Arguments> passwordContainsUpperCase(){
        return Stream.of(
                arguments(true, "Cookies"),
                arguments(true, "longPassword"),
                arguments(false, "ghhjagn89hhj"),
                arguments(true, "BBHDGLLNNGTT890"),
                arguments(true, "long89Password"),
                arguments(true, "67extra5stRong")
        );
    }
}
