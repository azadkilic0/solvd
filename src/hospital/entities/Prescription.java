package hospital.entities;

import exceptions.InvalidPrescriptionException;

import java.util.Objects;
import java.util.logging.Logger;

public class Prescription {
    private String medicationName;
    private String dosage;
    private Patient patient;
    private Doctor doctor;
    private static final Logger logger = Logger.getLogger(Prescription.class.getName());

    public Prescription(String medicationName, String dosage, Patient patient, Doctor doctor) {
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.patient = patient;
        this.doctor = doctor;
    }

    public void validatePrescription(String prescription) {
        if (prescription == null || prescription.isEmpty()) {
            throw new InvalidPrescriptionException("Invalid prescription provided.");
        }
        logger.info("Prescription validated: " + prescription);
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

    public String getMedication() {
        return medicationName;
    }

    public void setMedication(String medication) {
        this.medicationName = medication;
    }
}
