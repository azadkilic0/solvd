import Management.Department;
import Management.Hospital;
import hospital.entities.*;
import services.Appointment;
import hospital.services.HospitalService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a hospital
        Hospital hospital = new Hospital("City Hospital", "123 Main St");

        // Creating a HospitalService instance
        HospitalService hospitalService = new HospitalService(hospital, 100); // Managing hospital operations

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
        Patient patient2 = new Patient("Sarah Black", LocalDate.of(2000, 1, 15), "Migraine", LocalDate.of(2023, 9, 16));

        hospitalService.addPatient(patient1);
        hospitalService.addPatient(patient2);

        // Creating medical records
        MedicalRecord record1 = new MedicalRecord(patient1, doctor1);
        MedicalRecord record2 = new MedicalRecord(patient2, doctor2);

        record1.addDiagnosis("Acute Myocardial Infarction");
        record1.addTreatment("Angioplasty");

        record2.addDiagnosis("Chronic Migraine");
        record2.addTreatment("Pain Management Therapy");



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

//        // Merge sort functionality demonstration
//        System.out.println("Merge Sort Example");
//        System.out.println("Enter the elements of the array separated by space:");
//        String[] arrayInput = scanner.nextLine().split(" ");
//        int[] array = new int[arrayInput.length];
//
//        try {
//            for (int i = 0; i < arrayInput.length; i++) {
//                array[i] = Integer.parseInt(arrayInput[i]);
//            }
//            mergeSort(array, 0, array.length - 1);
//
//            System.out.println("Sorted array:");
//            for (int num : array) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        } catch (NumberFormatException e) {
//            System.out.println("Error: All input values must be integers.");
//        }

        scanner.close();
    }

    // Merge sort algorithm
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
