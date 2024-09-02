package exceptions;

public class InvalidPrescriptionException extends RuntimeException {
    private String message;

    public InvalidPrescriptionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
