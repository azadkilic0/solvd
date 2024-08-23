package hospital.entities;

import java.util.Objects;

public class Prescription {
    private String medicationName;
    private String dosage;
    private Patient patient;
    private Doctor doctor;

    public Prescription(String medicationName, String dosage, Patient patient, Doctor doctor) {
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.patient = patient;
        this.doctor = doctor;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "medicationName='" + medicationName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", patient=" + patient.getName() +
                ", doctor=" + doctor.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(medicationName, that.medicationName) &&
                Objects.equals(dosage, that.dosage) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(doctor, that.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationName, dosage, patient, doctor);
    }
}
