package hospital;

/**
 * EmergencyQueue implements a FIFO (First-In-First-Out) queue
 * to manage patients waiting for emergency treatment.
 */

public class EmergencyQueue {

    // Node class for the queue (using linked list internally)
    private class QNode {
        Patient patient;
        QNode next;

        QNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QNode front; // patient to be treated next
    private QNode rear;  // last patient added
    private int size;

    public EmergencyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // ---------- ENQUEUE ----------
    public void enqueue(Patient patient) {
        QNode newNode = new QNode(patient);

        if (rear == null) {
            // queue is empty
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
    }

    // ---------- DEQUEUE ----------
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty. No patients waiting.");
            return null;
        }

        Patient treatedPatient = front.patient;
        front = front.next;

        if (front == null) {
            rear = null; // queue is now empty
        }

        size--;
        return treatedPatient;
    }

    // ---------- DISPLAY ----------
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting.");
            return;
        }

        System.out.println("Patients waiting in emergency queue:");
        QNode current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }

    // ---------- EMPTY CHECK ----------
    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }
}