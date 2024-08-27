package hospital.entities;

import java.time.LocalDate;
import java.util.Objects;
import Accounting.Billing;
import Accounting.Invoice;
import Accounting.Payment;
public class Patient extends Person {
    protected String disease;
    private LocalDate admissionDate;
    private Billing[] billingRecords;
    private Payment[] payments;
    private int billingCount;
    private int paymentCount;
    public Patient(String name, LocalDate birthDate, String disease, LocalDate admissionDate) {
        super(name, birthDate);
        this.disease = disease;
        this.admissionDate = admissionDate;
    }
    public void addBilling(Billing billing) {
        if (billingCount >= billingRecords.length) {
            billingRecords = expandArray(billingRecords);
        }
        billingRecords[billingCount++] = billing;
    }

    public void addPayment(Payment payment) {
        if (paymentCount >= payments.length) {
            payments = expandArray(payments);
        }
        payments[paymentCount++] = payment;
    }

    public Billing[] getBillingRecords() {
        return billingRecords.clone();
    }

    public Payment[] getPayments() {
        return payments.clone();
    }

    private Billing[] expandArray(Billing[] original) {
        Billing[] newArray = new Billing[original.length * 2];
        System.arraycopy(original, 0, newArray, 0, original.length);
        return newArray;
    }

    private Payment[] expandArray(Payment[] original) {
        Payment[] newArray = new Payment[original.length * 2];
        System.arraycopy(original, 0, newArray, 0, original.length);
        return newArray;
    }
    @Override
    public void work() {
        System.out.println("Patient " + getName() + " is resting to recover.");
    }

    // Implement the performDuties() method from the Person class
    @Override
    public void performDuties() {
        // For example, you might log or handle patient-related duties here
        System.out.println("Patient " + getName() + " is undergoing treatment for " + disease + ".");
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
