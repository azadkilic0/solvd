package exceptions;

public class InvalidAppointmentException extends Exception {
    private String message;

    public InvalidAppointmentException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
