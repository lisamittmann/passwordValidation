public class PasswordValidation {

    public static boolean validatePassword(String password) {
        return checkIfLongEnough(password) && checkIfContainsNumbers(password)
                && checkIfContainsLowerCase(password) && checkIfContainsUpperCase(password);
    }

    public static boolean checkIfLongEnough(String password) {
        return password.length() > 8;
    }

    public static boolean checkIfContainsNumbers(String password) {
        return password.matches(".*[0-9].*");
    }

    public static boolean checkIfContainsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    public static boolean checkIfContainsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }
}
