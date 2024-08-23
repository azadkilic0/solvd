package Accounting;

import java.time.LocalDate;

public class Invoice {
    private Billing billing;
    private LocalDate invoiceDate;
    private boolean paid;

    public Invoice(Billing billing) {
        this.billing = billing;
        this.invoiceDate = LocalDate.now();
        this.paid = false;
    }

    public void markAsPaid() {
        this.paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "billing=" + billing +
                ", invoiceDate=" + invoiceDate +
                ", paid=" + paid +
                '}';
    }
}
