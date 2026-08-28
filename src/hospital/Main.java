package hospital;

import java.util.Scanner;

public class Main {

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1: addPatient(); break;
                case 2: searchPatient(); break;
                case 3: deletePatient(); break;
                case 4: patientBST.displayInOrder(); break;
                case 5: enqueuePatient(); break;
                case 6: dequeuePatient(); break;
                case 7: emergencyQueue.displayQueue(); break;
                case 8: pushTreatment(); break;
                case 9: treatmentStack.pop(); break;
                case 10: treatmentStack.displayTreatments(); break;
                case 11: addVisit(); break;
                case 12: removeVisit(); break;
                case 13: searchVisit(); break;
                case 14: displayVisitHistory(); break;
                case 0: System.out.println("Exiting system. Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n===== Mini Hospital Emergency Management System =====");
        System.out.println("--- Patient Records (BST) ---");
        System.out.println("1. Add Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients (In-order)");
        System.out.println("--- Emergency Queue ---");
        System.out.println("5. Enqueue Patient (Add to waiting list)");
        System.out.println("6. Dequeue Patient (Next for treatment)");
        System.out.println("7. Display Waiting Queue");
        System.out.println("--- Treatment History (Stack) ---");
        System.out.println("8. Push Completed Treatment");
        System.out.println("9. Pop Last Treatment Record");
        System.out.println("10. Display Treatment History");
        System.out.println("--- Patient Visit History (Linked List) ---");
        System.out.println("11. Add Visit to Patient");
        System.out.println("12. Remove Visit from Patient");
        System.out.println("13. Search Visit for Patient");
        System.out.println("14. Display Patient Visit History");
        System.out.println("0. Exit");
    }

    // ---------- BST OPERATIONS ----------
    static void addPatient() {
        int id = getIntInput("Enter Patient ID: ");
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        int age = getIntInput("Enter Age: ");
        while (age <= 0 || age > 150) {
            System.out.println("Invalid age. Please enter a value between 1 and 150.");
            age = getIntInput("Enter Age: ");
        }
        scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
        System.out.println("Patient added successfully.");
    }

    static void searchPatient() {
        int id = getIntInput("Enter Patient ID to search: ");
        Patient found = patientBST.search(id);
        if (found != null) {
            System.out.println("Patient found: " + found);
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    static void deletePatient() {
        int id = getIntInput("Enter Patient ID to delete: ");
        patientBST.delete(id);
    }

    // ---------- QUEUE OPERATIONS ----------
    static void enqueuePatient() {
        int id = getIntInput("Enter Patient ID (must already exist in records): ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found. Please add patient first.");
            return;
        }
        emergencyQueue.enqueue(patient);
    }

    static void dequeuePatient() {
        Patient treated = emergencyQueue.dequeue();
        if (treated != null) {
            System.out.println("Now treating: " + treated);
        }
    }

    // ---------- STACK OPERATIONS ----------
    static void pushTreatment() {
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        scanner.nextLine();
        System.out.print("Enter Treatment Details: ");
        String details = scanner.nextLine();
        treatmentStack.push(patient, details);
    }

    // ---------- LINKED LIST OPERATIONS ----------
    static void addVisit() {
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = getIntInput("Enter Visit ID: ");
        scanner.nextLine();
        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
        patient.getVisitHistory().addVisit(visit);
    }

    static void removeVisit() {
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        int visitId = getIntInput("Enter Visit ID to remove: ");
        patient.getVisitHistory().removeVisit(visitId);
    }

    static void searchVisit() {
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        int visitId = getIntInput("Enter Visit ID to search: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);
        if (visit != null) {
            System.out.println("Visit found: " + visit);
        } else {
            System.out.println("Visit ID " + visitId + " not found for this patient.");
        }
    }

    static void displayVisitHistory() {
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        patient.getVisitHistory().displayHistory();
    }

    // ---------- HELPER ----------
    static int getIntInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print(message);
        }
        return scanner.nextInt();
    }
}