package Management;

import Interfaces.*;
import hospital.entities.MedicalRecord;
import hospital.entities.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Admin extends Person implements AdministrativeStaff, RecordKeeper  {
    private String role;
    private int yearsOfService;

    public Admin(String name, LocalDate birthDate, String role, int yearsOfService) {
        super(name, birthDate);
        this.role = role;
        this.yearsOfService = yearsOfService;
    }

    @Override
    public void work() {
        System.out.println("Admin " + getName() + " is managing hospital operations.");
    }

    @Override
    public void performDuties() {
        System.out.println("Admin " + getName() + " is performing administrative duties.");
        manageRecords();
        keepRecords();
        scheduleAppointments();
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public String toString() {
        return "Admin{name='" + getName() + "', birthDate=" + getBirthDate() +
                ", role='" + role + "', yearsOfService=" + yearsOfService + "}";
    }

    public String getRoleName() {
        return role;
    }

    public void setRoleName(String role) {
        this.role = role;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return yearsOfService == admin.yearsOfService && role.equals(admin.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, yearsOfService);
    }

    @Override
    public void manageRecords() {
        System.out.println("Admin " + getName() + " is managing medical records.");
    }

    @Override
    public void scheduleAppointments() {
        System.out.println("Admin " + getName() + " is scheduling appointments.");
    }

    @Override
    public void keepRecords() {
        System.out.println("Admin " + getName() + " is keeping records up-to-date.");
    }

    @Override
    public void updateRecords(MedicalRecord record) {
        System.out.println("Admin " + getName() + " is updating the medical record for patient: " + record.getPatient().getName());
    }
}
