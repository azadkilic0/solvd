package hospital.entities;

import Interfaces.MedicalProfessional;
import Interfaces.PatientCare;
import java.time.LocalDate;

public class Nurse extends Person implements MedicalProfessional, PatientCare  {
    private int yearsOfExperience;

    public Nurse(String name, LocalDate birthDate, int yearsOfExperience) {
        super(name, birthDate);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void work() {
        System.out.println("Nurse " + getName() + " is caring for patients.");
    }

    @Override
    public void performDuties() {
        System.out.println("Nurse " + getName() + " is performing all assigned nursing duties.");
        careForPatient(new Patient(getName(), getBirthDate(), "General Care", LocalDate.now()));
        provideAssistance(new Patient(getName(), getBirthDate(), "General Care", LocalDate.now()));
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    @Override
    public String toString() {
        return "Nurse{name='" + getName() + "', birthDate=" + getBirthDate() +
                ", yearsOfExperience=" + yearsOfExperience + "}";
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nurse nurse = (Nurse) o;
        return yearsOfExperience == nurse.yearsOfExperience;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(yearsOfExperience);
    }

    @Override
    public void treatPatient(Patient patient) {
        System.out.println("Nurse " + getName() + " is caring for patient " + patient.getName() + ".");
    }

    @Override
    public void prescribeMedication(Patient patient, Prescription prescription) {
        System.out.println("Nurse " + getName() + " is recommending medication: " + prescription.getMedication() + " to patient " + patient.getName() + ".");
    }

    @Override
    public void careForPatient(Patient patient) {
        System.out.println("Nurse " + getName() + " is providing general care to patient " + patient.getName() + ".");
    }

    @Override
    public void provideAssistance(Patient patient) {
        System.out.println("Nurse " + getName() + " is assisting patient " + patient.getName() + " with their daily activities.");
    }
}
