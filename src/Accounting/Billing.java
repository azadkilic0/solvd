package Accounting;

import hospital.entities.Patient;

import java.util.Arrays;

public class Billing {
    private Patient patient;
    private double totalAmount;
    private String[] services;
    private double[] costs;

    public Billing(Patient patient, String[] services) {
        this.patient = patient;
        this.services = services;
    }

    // Add a service and its cost
    public void addService(String service, double cost) {
        services = Arrays.copyOf(services, services.length + 1);
        services[services.length - 1] = service;

        costs = Arrays.copyOf(costs, costs.length + 1);
        costs[costs.length - 1] = cost;

        totalAmount += cost;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "patient=" + patient.getName() +
                ", totalAmount=" + totalAmount +
                ", services=" + Arrays.toString(services) +
                ", costs=" + Arrays.toString(costs) +
                '}';
    }

}
