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
        this.departments = new Department[10];  // Initialize with a size of 10
        this.doctors = new Doctor[10];
        this.nurses = new Nurse[10];
        this.patients = new Patient[10];
        this.admins = new Admin[10];
        this.medicalRecords = new MedicalRecord[10];
        this.equipments = new MedicalEquipment[10];
        this.appointments = new Appointment[10];
        this.prescriptions = new Prescription[10];
    }

    // Method to expand the array if full
    private <T> T[] expandArray(T[] array) {
        T[] newArray = Arrays.copyOf(array, array.length * 2);
        return newArray;
    }

    public void addDoctor(Doctor doctor) {
        if (doctors[doctors.length - 1] != null) {
            doctors = expandArray(doctors);
        }
        for (int i = 0; i < doctors.length; i++) {
            if (doctors[i] == null) {
                doctors[i] = doctor;
                break;
            }
        }
    }

    public void addNurse(Nurse nurse) {
        if (nurses[nurses.length - 1] != null) {
            nurses = expandArray(nurses);
        }
        for (int i = 0; i < nurses.length; i++) {
            if (nurses[i] == null) {
                nurses[i] = nurse;
                break;
            }
        }
    }

    public void addPatient(Patient patient) {
        if (patients[patients.length - 1] != null) {
            patients = expandArray(patients);
        }
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] == null) {
                patients[i] = patient;
                break;
            }
        }
    }

    public void addAdmin(Admin admin) {
        if (admins[admins.length - 1] != null) {
            admins = expandArray(admins);
        }
        for (int i = 0; i < admins.length; i++) {
            if (admins[i] == null) {
                admins[i] = admin;
                break;
            }
        }
    }

    public void addDepartment(Department department) {
        if (departments[departments.length - 1] != null) {
            departments = expandArray(departments);
        }
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] == null) {
                departments[i] = department;
                break;
            }
        }
    }

    public void addMedicalRecord(MedicalRecord record) {
        if (medicalRecords[medicalRecords.length - 1] != null) {
            medicalRecords = expandArray(medicalRecords);
        }
        for (int i = 0; i < medicalRecords.length; i++) {
            if (medicalRecords[i] == null) {
                medicalRecords[i] = record;
                break;
            }
        }
    }

    public void addEquipment(MedicalEquipment eq) {
        if (equipments[equipments.length - 1] != null) {
            equipments = expandArray(equipments);
        }
        for (int i = 0; i < equipments.length; i++) {
            if (equipments[i] == null) {
                equipments[i] = eq;
                break;
            }
        }
    }

    public void addAppointment(Appointment appointment) {
        if (appointments[appointments.length - 1] != null) {
            appointments = expandArray(appointments);
        }
        for (int i = 0; i < appointments.length; i++) {
            if (appointments[i] == null) {
                appointments[i] = appointment;
                break;
            }
        }
    }

    public void addPrescription(Prescription prescription) {
        if (prescriptions[prescriptions.length - 1] != null) {
            prescriptions = expandArray(prescriptions);
        }
        for (int i = 0; i < prescriptions.length; i++) {
            if (prescriptions[i] == null) {
                prescriptions[i] = prescription;
                break;
            }
        }
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
}
