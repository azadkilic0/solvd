package hospital.entities;

import exceptions.MedicalRecordNotFoundException;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

public class MedicalRecord {
    private Patient patient;
    private String[] diagnoses;
    private String[] treatments;
    private Doctor doctor;
    private static final Logger logger = Logger.getLogger(MedicalRecord.class.getName());

    public MedicalRecord(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public String getMedicalRecord(String patientId) throws MedicalRecordNotFoundException {
        String record = null;
        if (record == null) {
            throw new MedicalRecordNotFoundException("Medical record not found for patient ID: " + patientId);
        }
        return record;
    }

    // Method to add a diagnosis
    public void addDiagnosis(String diagnosis) {
        diagnoses = Arrays.copyOf(diagnoses, diagnoses.length + 1);
        diagnoses[diagnoses.length - 1] = diagnosis;
    }

    // Method to add a treatment
    public void addTreatment(String treatment) {
        treatments = Arrays.copyOf(treatments, treatments.length + 1);
        treatments[treatments.length - 1] = treatment;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "patient=" + patient.getName() +
                ", diagnoses=" + Arrays.toString(diagnoses) +
                ", treatments=" + Arrays.toString(treatments) +
                ", doctor=" + doctor.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalRecord that = (MedicalRecord) o;
        return Objects.equals(patient, that.patient) &&
                Objects.equals(doctor, that.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, doctor);
    }
}
