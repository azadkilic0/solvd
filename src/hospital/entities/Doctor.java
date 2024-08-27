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

    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public String toString() {
        return "Doctor{name='" + getName() + "', birthDate=" + getBirthDate() +
                ", specialty='" + specialty + "'}";
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
    public void treatPatient(Patient patient) {

    }

    @Override
    public void prescribeMedication(Patient patient, Prescription prescription) {

    }
}
