package hospital.entities;

import Interfaces.MedicalProfessional;
import java.time.LocalDate;

public class Doctor extends Person implements MedicalProfessional {
    private String specialty;

    public Doctor(String name, LocalDate birthDate, String specialty) {
        super(name, birthDate);
        this.specialty = specialty;
    }

    @Override
    public void work() {
        System.out.println("Doctor " + getName() + " is treating patients.");
    }

    @Override
    public void performDuties() {
        System.out.println("Doctor " + getName() + " is performing medical duties.");
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return specialty.equals(doctor.specialty);
    }

    @Override
    public int hashCode() {
        return specialty.hashCode();
    }

    @Override
    public String toString() {
        return "Doctor{name='" + getName() + "', birthDate=" + getBirthDate() +
                ", specialty='" + specialty + "'}";
    }

    @Override
    public void treatPatient(Patient patient) {
        System.out.println("Doctor " + getName() + " is treating patient " + patient.getName() + " for " + patient.getDisease() + ".");
    }

    @Override
    public void prescribeMedication(Patient patient, Prescription prescription) {
        System.out.println("Doctor " + getName() + " prescribes " + prescription.getMedication() + " to " + patient.getName() + ".");
    }

}
