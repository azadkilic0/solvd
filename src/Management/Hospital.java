package Management;

import hospital.entities.*;
import services.Appointment;

import java.util.Arrays;

public class Hospital {
    private String name;
    private String location;
    private Department[] departments;
    private Doctor[] doctors;
    private Nurse[] nurses;
    private Patient[] patients;
    private Admin[] admins;
    private MedicalRecord[] medicalRecords;
    private MedicalEquipment[] equipments;
    private Appointment[] appointments;
    private Prescription[] prescriptions;

    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;
        this.departments = new Department[0];  // Initialize as empty arrays
        this.doctors = new Doctor[0];
        this.nurses = new Nurse[0];
        this.patients = new Patient[0];
        this.admins = new Admin[0];
        this.medicalRecords = new MedicalRecord[0];
        this.equipments = new MedicalEquipment[0];
        this.appointments = new Appointment[0];
        this.prescriptions = new Prescription[0];
    }

    // Method to add a doctor
    public void addDoctor(Doctor doctor) {
        doctors = Arrays.copyOf(doctors, doctors.length + 1);
        doctors[doctors.length - 1] = doctor;
    }

    // Method to add a nurse
    public void addNurse(Nurse nurse) {
        nurses = Arrays.copyOf(nurses, nurses.length + 1);
        nurses[nurses.length - 1] = nurse;
    }

    // Method to add a patient
    public void addPatient(Patient patient) {
        patients = Arrays.copyOf(patients, patients.length + 1);
        patients[patients.length - 1] = patient;
    }

    // Method to add an admin
    public void addAdmin(Admin admin) {
        admins = Arrays.copyOf(admins, admins.length + 1);
        admins[admins.length - 1] = admin;
    }

    // Method to add a department
    public void addDepartment(Department department) {
        departments = Arrays.copyOf(departments, departments.length + 1);
        departments[departments.length - 1] = department;
    }

    // Method to add a medical record
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords = Arrays.copyOf(medicalRecords, medicalRecords.length + 1);
        medicalRecords[medicalRecords.length - 1] = record;
    }

    // Method to add medical equipment
    public void addEquipment(MedicalEquipment equipment) {
        equipments = Arrays.copyOf(equipments, equipments.length + 1);
        equipments[equipments.length - 1] = equipment;
    }

    // Method to add an appointment
    public void addAppointment(Appointment appointment) {
        appointments = Arrays.copyOf(appointments, appointments.length + 1);
        appointments[appointments.length - 1] = appointment;
    }

    // Method to add a prescription
    public void addPrescription(Prescription prescription) {
        prescriptions = Arrays.copyOf(prescriptions, prescriptions.length + 1);
        prescriptions[prescriptions.length - 1] = prescription;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public Nurse[] getNurses() {
        return nurses;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public Admin[] getAdmins() {
        return admins;
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords;
    }

    public MedicalEquipment[] getEquipments() {
        return equipments;
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public Prescription[] getPrescriptions() {
        return prescriptions;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", departments=" + Arrays.toString(departments) +
                ", doctors=" + Arrays.toString(doctors) +
                ", nurses=" + Arrays.toString(nurses) +
                ", patients=" + Arrays.toString(patients) +
                ", admins=" + Arrays.toString(admins) +
                ", medicalRecords=" + Arrays.toString(medicalRecords) +
                ", equipments=" + Arrays.toString(equipments) +
                ", appointments=" + Arrays.toString(appointments) +
                ", prescriptions=" + Arrays.toString(prescriptions) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
