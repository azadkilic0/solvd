package hospital.services;

import hospital.entities.Patient;
import hospital.entities.Person;
import Management.Department;
import Management.Hospital;

import java.util.Arrays;

public class HospitalService {
    // Static variable
    private static final String DEFAULT_HOSPITAL_NAME = "Default Hospital";

    // Static block
    static {
        System.out.println("HospitalService class loaded. Default hospital name is: " + DEFAULT_HOSPITAL_NAME);
    }

    private Hospital hospital;
    private Patient[] patients;
    private Department[] departments;
    private int maxBeds;

    public HospitalService(Hospital hospital, int maxBeds) {
        this.hospital = hospital;
        this.patients = new Patient[maxBeds];
        this.departments = new Department[0];  // Initialize as an empty array
    }

    // Static method
    public static void displayDefaultHospitalName() {
        System.out.println("The default hospital name is: " + DEFAULT_HOSPITAL_NAME);
    }

    public void displayHospitalInfo() {
        System.out.println("Welcome to " + hospital.getName() + " located at " + hospital.getLocation());
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
        departments = Arrays.copyOf(departments, departments.length + 1);
        departments[departments.length - 1] = department;
        System.out.println("Department added: " + department.getName());
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
