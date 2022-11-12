import java.util.Objects;

public class CredentialsValidator {
    private static final String INVALID_LENGHT = "Длина логина может быть от 1 до 20 символов";
    private static final String INVALID_LENGHT_PASSWORD = "Длина пароля может быть от 1 до 20 символов";
    private static final String INVALID_SYMBOL_LOGIN = "логин должен содержать только латинские буквы, цифры и знак подчеркивания";
    private static final String INVALID_SYMBOL_PASWORD = "пароль должен содержать только латинские буквы, цифры и знак подчеркивания";
    private static final String PASSWORD_NOT_MATCH = "Пароли не совпадают";

    public static boolean validateCredentials(String login,
                                              String password,
                                              String confirmPassword) {
        if (isLenghtNotInRange(login, 1, 20)) {
            throw new WrongLoginException(INVALID_LENGHT);
        }
        if (issymbolnotvalidLogin(login)) {
            throw new WrongLoginException(INVALID_SYMBOL_LOGIN);
        }
        if (isLenghtNotInRangePassword(password, 1, 20)) {
            throw new WrongPasswordException(INVALID_LENGHT_PASSWORD);
        }
        if (issymbolnotvalidPassword(password)) {
            throw new WrongPasswordException(INVALID_SYMBOL_PASWORD);
        }
        if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException(PASSWORD_NOT_MATCH);
        }
        return true;
    }

    private static boolean isLenghtNotInRange(String value, int min, int max) {
        if (value == null) {
            return true;
        }
        int lenght = value.length();
        return lenght < min || lenght > max;
    }

    private static boolean isLenghtNotInRangePassword(String value, int min, int max) {
        if (value == null) {
            return true;
        }
        int lenght = value.length();
        return lenght < min || lenght > max;
    }

    private static boolean issymbolnotvalidLogin(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        for (char c : value.toCharArray()) {
            boolean symbolMatches = (c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (Character.isDigit(c))
                    || (c == '_');
            if (!symbolMatches) {
                return true;
            }
        }
        return false;
    }

    private static boolean issymbolnotvalidPassword(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        for (char c : value.toCharArray()) {
            boolean symbolMatches = (c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (Character.isDigit(c))
                    || (c == '_');
            if (!symbolMatches) {
                return true;
            }
        }
        return false;
    }


}
