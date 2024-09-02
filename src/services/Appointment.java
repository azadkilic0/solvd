package services;

import exceptions.InvalidAppointmentException;
import hospital.entities.Doctor;
import hospital.entities.Patient;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Appointment {
    private LocalDate date;
    private Doctor doctor;
    private Patient patient;

    private static final Logger logger = Logger.getLogger(Appointment.class.getName());

    public Appointment(LocalDate date, Doctor doctor, Patient patient) throws InvalidAppointmentException {
        if (date == null) {
            throw new InvalidAppointmentException("Appointment date cannot be null.");
        }
        if (doctor == null) {
            throw new InvalidAppointmentException("Doctor cannot be null.");
        }
        if (patient == null) {
            throw new InvalidAppointmentException("Patient cannot be null.");
        }
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
        logger.info("Appointment created successfully: " + this.toString());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) throws InvalidAppointmentException {
        if (date == null) {
            throw new InvalidAppointmentException("Appointment date cannot be null.");
        }
        this.date = date;
        logger.info("Appointment date updated to: " + date);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) throws InvalidAppointmentException {
        if (doctor == null) {
            throw new InvalidAppointmentException("Doctor cannot be null.");
        }
        this.doctor = doctor;
        logger.info("Appointment doctor updated to: " + doctor.getName());
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) throws InvalidAppointmentException {
        if (patient == null) {
            throw new InvalidAppointmentException("Patient cannot be null.");
        }
        this.patient = patient;
        logger.info("Appointment patient updated to: " + patient.getName());
    }

    public void validateAppointment() throws InvalidAppointmentException {
        if (date.isBefore(LocalDate.now())) {
            throw new InvalidAppointmentException("Appointment date cannot be in the past.");
        }

        logger.info("AppoDintment is valid: " + this.toString());
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                '}';
    }
}
