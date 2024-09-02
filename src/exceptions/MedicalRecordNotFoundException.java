package exceptions;

public class MedicalRecordNotFoundException extends Exception {
    private String message;

    public MedicalRecordNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
