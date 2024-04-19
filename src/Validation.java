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

    public static void checkValidation(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        boolean testLogin = login.matches("^\\w++$");
        boolean testPassword = password.matches("^\\w++$");

        if (!testLogin || login.length() > 20) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания. Длина логина не больше 20 символов.");
        }
        if ((!testPassword || password.length() > 20)) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания. Длина пароля не больше 20 символов.");
        } else if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
    }
}


