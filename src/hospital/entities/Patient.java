package hospital.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Patient extends Person {
    protected String disease;
    private LocalDate admissionDate;

    public Patient(String name, LocalDate birthDate, String disease, LocalDate admissionDate) {
        super(name, birthDate);
        this.disease = disease;
        this.admissionDate = admissionDate;
    }

    @Override
    public void work() {
        System.out.println("Patient " + getName() + " is resting to recover.");
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + getName() + '\'' +
                ", birthDate=" + getBirthDate() +
                ", disease='" + disease + '\'' +
                ", admissionDate=" + admissionDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(disease, patient.disease) &&
                Objects.equals(admissionDate, patient.admissionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disease, admissionDate);
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
}
