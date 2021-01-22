public class PasswordValidation {

    public static boolean[] validatePassword(String[] password) {

        boolean[] checkResults = new boolean[password.length];

        for(int i = 0; i < password.length; i++) {
            boolean isValid = checkIfLongEnough(password[i]) && checkIfContainsNumbers(password[i])
                    && checkIfContainsLowerCase(password[i]) && checkIfContainsUpperCase(password[i]);
            checkResults[i] = isValid;
        }

        return checkResults;
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
