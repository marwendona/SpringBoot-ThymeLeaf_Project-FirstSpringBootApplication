package tn.iit.exception;

public class CompteNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CompteNotFoundException(String message) {
        super(message);
    }
}
