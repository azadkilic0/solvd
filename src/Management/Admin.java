package Management;

import hospital.entities.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Admin extends Person {
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
}
