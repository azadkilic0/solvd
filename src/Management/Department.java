package Management;

import hospital.entities.Doctor;
import hospital.entities.MedicalEquipment;
import hospital.entities.Nurse;

import java.util.Arrays;
import java.util.Objects;

public class Department {
    private String name;
    private Doctor[] doctors;
    private Nurse[] nurses;
    private MedicalEquipment[] equipment;
    private int maxBeds;  // Maximum number of beds available in this department
    private int currentPatientCount;  // Current number of patients admitted in this department

    public Department(String name, int maxDoctors, int maxNurses, int maxEquipment, int maxBeds) {
        this.name = name;
        this.doctors = new Doctor[maxDoctors];
        this.nurses = new Nurse[maxNurses];
        this.equipment = new MedicalEquipment[maxEquipment];
        this.maxBeds = maxBeds;
        this.currentPatientCount = 0;
    }


    public void addDoctor(Doctor doctor) {
        for (int i = 0; i < doctors.length; i++) {
            if (doctors[i] == null) {
                doctors[i] = doctor;
                System.out.println("Doctor added to " + name + ": " + doctor.getName());
                return;
            }
        }
        System.out.println("Cannot add doctor to " + name + ". Department is full.");
    }

    public void addNurse(Nurse nurse) {
        for (int i = 0; i < nurses.length; i++) {
            if (nurses[i] == null) {
                nurses[i] = nurse;
                System.out.println("Nurse added to " + name + ": " + nurse.getName());
                return;
            }
        }
        System.out.println("Cannot add nurse to " + name + ". Department is full.");
    }

    public void addEquipment(MedicalEquipment equipment) {
        for (int i = 0; i < this.equipment.length; i++) {
            if (this.equipment[i] == null) {
                this.equipment[i] = equipment;
                System.out.println("Equipment added to " + name + ": " + equipment.getName());
                return;
            }
        }
        System.out.println("Cannot add equipment to " + name + ". Department is full.");
    }

    public boolean admitPatient() {
        if (currentPatientCount < maxBeds) {
            currentPatientCount++;
            System.out.println("Patient admitted to " + name + ". Current patient count: " + currentPatientCount);
            return true;
        } else {
            System.out.println("Cannot admit patient to " + name + ". Department is full.");
            return false;
        }
    }

    public void dischargePatient() {
        if (currentPatientCount > 0) {
            currentPatientCount--;
            System.out.println("Patient discharged from " + name + ". Current patient count: " + currentPatientCount);
        } else {
            System.out.println("No patients to discharge from " + name + ".");
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public Doctor[] getDoctors() {
        return doctors.clone();
    }

    public Nurse[] getNurses() {
        return nurses.clone();
    }

    public MedicalEquipment[] getEquipment() {
        return equipment.clone();
    }

    public int getMaxBeds() {
        return maxBeds;
    }

    public int getCurrentPatientCount() {
        return currentPatientCount;
    }



    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", doctors=" + Arrays.toString(doctors) +
                ", nurses=" + Arrays.toString(nurses) +
                ", equipment=" + Arrays.toString(equipment) +
                ", maxBeds=" + maxBeds +
                ", currentPatientCount=" + currentPatientCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return maxBeds == that.maxBeds &&
                currentPatientCount == that.currentPatientCount &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxBeds, currentPatientCount);
    }
}
