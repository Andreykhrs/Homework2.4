import exception.WrongLoginException;
import exception.WrongPasswordException;

import java.util.Objects;

public class Validation {

    private String login;
    private String password;
    private String confirmPassword;

    public Validation(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

//    private static final char[] m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_',
//            'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J',
//            'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M',
//            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j',
//            'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};

    public static void checkValidation(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        boolean testLogin = login.matches("^[\\w+]+$");
        boolean testPassword = password.matches("^[\\w+]+$");

        if (!testLogin || login.length() >= 20) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания. Длина логина не больше 20 символов.");
        }
        if ((!testPassword || password.length() >= 20)) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания. Длина пароля не больше 20 символов.");
        } else if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
    }
}


