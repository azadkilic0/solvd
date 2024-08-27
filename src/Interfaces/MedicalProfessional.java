package Interfaces;
import hospital.entities.Patient;
import hospital.entities.Prescription;

public interface MedicalProfessional extends HospitalStaff {
    void treatPatient(Patient patient);
    void prescribeMedication(Patient patient, Prescription prescription);
}