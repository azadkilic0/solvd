package hospital.entities;

import java.time.LocalDate;

public class Nurse extends Person {
    private int yearsOfExperience;

    public Nurse(String name, LocalDate birthDate, int yearsOfExperience) {
        super(name, birthDate);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void work() {
        System.out.println("Nurse " + getName() + " is caring for patients.");
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    @Override
    public String toString() {
        return "Nurse{name='" + getName() + "', birthDate=" + getBirthDate() +
                ", yearsOfExperience=" + yearsOfExperience + "}";
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nurse nurse = (Nurse) o;
        return yearsOfExperience == nurse.yearsOfExperience;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(yearsOfExperience);
    }
}
