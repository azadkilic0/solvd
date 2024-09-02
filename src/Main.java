import Accounting.Billing;
import Accounting.Invoice;
import Accounting.Payment;
import Management.Department;
import Management.Hospital;
import hospital.entities.*;
import services.Appointment;
import hospital.services.HospitalService;
import exceptions.InvalidAppointmentException;
import exceptions.InvalidPrescriptionException;
import exceptions.MedicalRecordNotFoundException;
import exceptions.PatientNotFoundException;
import exceptions.InsufficientFundsException;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("main.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.severe("Failed to set up logger file handler: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        logger.info("Starting the Hospital Management System");

        Scanner scanner = new Scanner(System.in);

        try {
            // Creating a hospital
            Hospital hospital = new Hospital("City Hospital", "123 merge_sort St");
            logger.info("Created hospital: " + hospital.getName());

            // Creating a HospitalService instance
            HospitalService hospitalService = new HospitalService(hospital, 100);
            logger.info("Created HospitalService for " + hospital.getName());

            // Creating departments
            Department cardiology = new Department("Cardiology", 20, 30, 10, 100);
            Department neurology = new Department("Neurology", 15, 20, 5, 80);

            hospitalService.addDepartment(cardiology);
            hospitalService.addDepartment(neurology);

            // Creating doctors
            Doctor doctor1 = new Doctor("Dr. John Smith", LocalDate.of(1980, 5, 15), "Cardiologist");
            Doctor doctor2 = new Doctor("Dr. Jane Doe", LocalDate.of(1975, 8, 25), "Neurologist");

            cardiology.addDoctor(doctor1);
            neurology.addDoctor(doctor2);

            // Creating nurses
            Nurse nurse1 = new Nurse("Alice Brown", LocalDate.of(1990, 2, 10), 5);
            Nurse nurse2 = new Nurse("Bob White", LocalDate.of(1985, 11, 5), 10);

            cardiology.addNurse(nurse1);
            neurology.addNurse(nurse2);

            // Creating medical equipment
            MedicalEquipment ecgMachine = new MedicalEquipment("ECG Machine", "ECG-1234");
            MedicalEquipment mriScanner = new MedicalEquipment("MRI Scanner", "MRI-5678");

            cardiology.addEquipment(ecgMachine);
            neurology.addEquipment(mriScanner);

            // Creating patients
            Patient patient1 = new Patient("Tom Green", LocalDate.of(1995, 7, 20), "Heart Disease", LocalDate.of(2023, 9, 15));
            String[] services = {"Consultation"};
            Patient patient2 = new Patient("Sarah Black", LocalDate.of(2000, 1, 15), "Migraine", LocalDate.of(2023, 9, 16));

            hospitalService.addPatient(patient1);
            hospitalService.addPatient(patient2);

            // Creating medical records
            MedicalRecord record1 = new MedicalRecord(patient1, doctor1);
            MedicalRecord record2 = new MedicalRecord(patient2, doctor2);

            // Creating appointments
            Appointment appointment1 = new Appointment(LocalDate.of(2023, 9, 18), doctor1, patient1);
            Appointment appointment2 = new Appointment(LocalDate.of(2023, 9, 19), doctor2, patient2);

            // Creating prescriptions
            Prescription prescription1 = new Prescription("Aspirin", "100mg once daily", patient1, doctor1);
            Prescription prescription2 = new Prescription("Sumatriptan", "50mg as needed", patient2, doctor2);

            // Displaying hospital information
            hospitalService.displayHospitalInfo();


            // Display details of specific persons using HospitalService static method
            HospitalService.displayPersonDetails(doctor1);
            HospitalService.displayPersonDetails(nurse1);
            HospitalService.displayPersonDetails(patient1);

            // Process persons
            hospitalService.processPerson(patient1);
            hospitalService.processPerson(doctor1);

            // Scanner logic to enter new patient details
            System.out.println("Enter a new patient's details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Birth Date (YYYY-MM-DD): ");
            LocalDate birthDate = LocalDate.parse(scanner.nextLine());
            System.out.print("Disease: ");
            String disease = scanner.nextLine();
            System.out.print("Admission Date (YYYY-MM-DD): ");
            LocalDate admissionDate = LocalDate.parse(scanner.nextLine());

            Patient newPatient = new Patient(name, birthDate, disease, admissionDate);
            hospitalService.addPatient(newPatient);

            System.out.println("New patient added: " + newPatient);

            // Handling exceptions with appointments
            try {
                Appointment invalidAppointment = new Appointment(LocalDate.of(2022, 1, 1), doctor1, patient1);
            } catch (InvalidAppointmentException e) {
                logger.severe("Invalid appointment creation: " + e.getMessage());
            }

            // Handling exceptions with prescriptions
            try {
                Prescription invalidPrescription = new Prescription("", "50mg as needed", patient2, doctor2);
            } catch (InvalidPrescriptionException e) {
                logger.severe("Invalid prescription creation: " + e.getMessage());
            }
            Billing billing1 = new Billing(patient1, services);
            try {
                Payment payment = new Payment(new Invoice(billing1), 5000);
                patient1.addPayment(payment);
            } catch (InsufficientFundsException e) {
                logger.severe("Payment processing failed: " + e.getMessage());
            }

        } catch (Exception e) {
            logger.severe("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
        logger.info("Hospital Management System operations completed.");
    }

}