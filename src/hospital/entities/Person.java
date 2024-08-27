package hospital.entities;

import Interfaces.*;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person implements HospitalStaff {
    private String name;
    private LocalDate birthDate;
    private static int instanceCount;

    static {
        instanceCount = 0;
        System.out.println("Person class loaded. Instance count set to 0.");
    }


    protected Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public abstract void work();

    public abstract String getRole();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }
}
