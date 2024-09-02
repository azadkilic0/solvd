package hospital.entities;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Accounting.Billing;
import Accounting.Payment;
import exceptions.InsufficientFundsException;


public class Patient extends Person {
    protected String disease;

    private LocalDate admissionDate;
    private Billing[] billingRecords;
    private Payment[] payments;
    private int billingCount;
    private int paymentCount;
    private static final Logger logger = Logger.getLogger(Patient.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("patient.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.severe("Failed to set up logger file handler: " + e.getMessage());
        }
    }

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
        double totalBilled = calculateTotalBilled();
        double totalPaid = calculateTotalPaid();

        if (totalPaid + payment.getAmountPaid() > totalBilled) {
            logger.severe("Insufficient funds to process payment of $"
                    + payment.getAmountPaid() + " for patient " + getName());
            throw new InsufficientFundsException("Insufficient funds to process payment of $"
                    + payment.getAmountPaid() + " for patient " + getName());
        }

        if (paymentCount >= payments.length) {
            payments = expandArray(payments);
        }
        payments[paymentCount++] = payment;

        logger.info("Payment of $" + payment.getAmountPaid() + " processed successfully for patient " + getName());

        // Log payment details to a file using try-with-resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("payment_details.log", true))) {
            writer.write("Payment recorded: $" + payment.getAmountPaid() + " for patient " + getName() + "\n");
        } catch (IOException e) {
            logger.severe("Failed to log payment details: " + e.getMessage());
        }
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

    private double calculateTotalBilled() {
        double total = 0;
        for (int i = 0; i < billingCount; i++) {
            total += billingRecords[i].getTotalAmount();
        }
        return total;
    }

    private double calculateTotalPaid() {
        double total = 0;
        for (int i = 0; i < paymentCount; i++) {
            total += payments[i].getAmountPaid();
        }
        return total;
    }

    @Override
    public void work() {
        System.out.println("Patient " + getName() + " is resting to recover.");
    }

    @Override
    public void performDuties() {
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