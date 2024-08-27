package hospital.entities;

import java.time.LocalDate;

public final class Surgeon extends Doctor {
    public static final String SPECIALTY = "Surgery";

    public Surgeon(String name, LocalDate birthDate, String specialty) {
        super(name, birthDate, specialty);
    }

    // Final method
    public final void performSurgery(Patient patient) {
        System.out.println("Performing surgery on " + patient.getName());
    }

    @Override
    public void treatPatient(Patient patient) {
        System.out.println("Surgeon treating patient " + patient.getName());
    }

    @Override
    public void prescribeMedication(Patient patient, Prescription prescription) {
        System.out.println("Surgeon prescribing medication to " + patient.getName());
    }

    @Override
    public void performDuties() {
        System.out.println("Surgeon performing duties.");
    }

    @Override
    public String getRole() {
        return SPECIALTY;
    }
}
