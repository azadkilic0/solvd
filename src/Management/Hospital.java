package Management;

import Accounting.*;
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
    private Billing[] billings;
    private Invoice[] invoices;
    private Payment[] payments;
    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;

    }

    // Method to add a billing record
    public void addBilling(Billing billing) {
        billings = Arrays.copyOf(billings, billings.length + 1);
        billings[billings.length - 1] = billing;
    }

    // Method to add an invoice
    public void addInvoice(Invoice invoice) {
        invoices = Arrays.copyOf(invoices, invoices.length + 1);
        invoices[invoices.length - 1] = invoice;
    }
    public void addDoctor(Doctor doctor) {
        doctors = Arrays.copyOf(doctors, doctors.length + 1);
        doctors[doctors.length - 1] = doctor;
    }


    public void addNurse(Nurse nurse) {
        nurses = Arrays.copyOf(nurses, nurses.length + 1);
        nurses[nurses.length - 1] = nurse;
    }


    public void addPatient(Patient patient) {
        patients = Arrays.copyOf(patients, patients.length + 1);
        patients[patients.length - 1] = patient;
    }


    public void addAdmin(Admin admin) {
        admins = Arrays.copyOf(admins, admins.length + 1);
        admins[admins.length - 1] = admin;
    }


    public void addDepartment(Department department) {
        departments = Arrays.copyOf(departments, departments.length + 1);
        departments[departments.length - 1] = department;
    }


    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords = Arrays.copyOf(medicalRecords, medicalRecords.length + 1);
        medicalRecords[medicalRecords.length - 1] = record;
    }

    public void addEquipment(MedicalEquipment equipment) {
        equipments = Arrays.copyOf(equipments, equipments.length + 1);
        equipments[equipments.length - 1] = equipment;
    }


    public void addAppointment(Appointment appointment) {
        appointments = Arrays.copyOf(appointments, appointments.length + 1);
        appointments[appointments.length - 1] = appointment;
    }


    public void addPrescription(Prescription prescription) {
        prescriptions = Arrays.copyOf(prescriptions, prescriptions.length + 1);
        prescriptions[prescriptions.length - 1] = prescription;
    }

    public Billing[] getBillings() {
        return billings;
    }

    public Invoice[] getInvoices() {
        return invoices;
    }

    public Payment[] getPayments() {
        return payments;
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
                ", billings=" + Arrays.toString(billings) +
                ", invoices=" + Arrays.toString(invoices) +
                ", payments=" + Arrays.toString(payments) +
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
