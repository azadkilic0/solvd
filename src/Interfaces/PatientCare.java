package Interfaces;

import hospital.entities.Patient;

public interface PatientCare {
    void careForPatient(Patient patient);
    void provideAssistance(Patient patient);
}