package hospital.services;

import hospital.entities.Patient;
import hospital.entities.Person;
import Management.Department;

public class HospitalService {
    private Patient[] patients;
    private Department[] departments;
    private int maxBeds;

    public HospitalService(int maxBeds) {
        this.maxBeds = maxBeds;
        this.patients = new Patient[maxBeds];
        this.departments = new Department[10];
    }

    public void addPatient(Patient patient) {
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] == null) {
                patients[i] = patient;
                System.out.println("Patient added: " + patient.getName());
                return;
            }
        }
        System.out.println("Cannot add patient. Hospital is full.");
    }

    public void removePatient(Patient patient) {
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] != null && patients[i].equals(patient)) {
                patients[i] = null;
                System.out.println("Patient removed: " + patient.getName());
                return;
            }
        }
        System.out.println("Patient not found: " + patient.getName());
    }

    public void addDepartment(Department department) {
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] == null) {
                departments[i] = department;
                System.out.println("Department added: " + department.getName());
                return;
            }
        }
        System.out.println("Cannot add department. Maximum capacity reached.");
    }

    public Patient[] getPatients() {
        return patients.clone();
    }

    public Department[] getDepartments() {
        return departments.clone();
    }

    public int getMaxBeds() {
        return maxBeds;
    }

    public void setMaxBeds(int maxBeds) {
        this.maxBeds = maxBeds;
        // Resize the patients array if maxBeds is changed
        Patient[] newPatients = new Patient[maxBeds];
        System.arraycopy(patients, 0, newPatients, 0, Math.min(patients.length, maxBeds));
        this.patients = newPatients;
    }

    public static void displayPersonDetails(Person person) {
        System.out.println(person.toString());
    }

    public void processPerson(Person person) {
        if (person instanceof Patient) {
            System.out.println("Processing patient: " + person.getName());
        } else {
            System.out.println("Processing person: " + person.getName());
        }
    }
}
