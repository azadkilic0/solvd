package exceptions;

public class PatientNotFoundException extends Exception {
    private String message;

    public PatientNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
