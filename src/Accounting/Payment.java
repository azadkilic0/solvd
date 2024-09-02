package Accounting;

import java.time.LocalDate;

public class Payment {
    private Invoice invoice;
    private double amountPaid;
    private LocalDate paymentDate;

    public Payment(Invoice invoice, double amountPaid) {
        this.invoice = invoice;
        this.amountPaid = amountPaid;
        this.paymentDate = LocalDate.now();
        this.invoice.markAsPaid();
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "invoice=" + invoice +
                ", amountPaid=" + amountPaid +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
