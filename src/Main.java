import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {

        try {
            Validation.checkValidation("Wdfcsdva", "a", "a");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}