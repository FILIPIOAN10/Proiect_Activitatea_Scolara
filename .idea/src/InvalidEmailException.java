public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Email address is not valid");
    }
}
