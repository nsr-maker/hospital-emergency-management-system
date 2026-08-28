package hospital;

public class TreatmentStack {

    // Node class for the stack (using linked list internally)
    private class SNode {
        Patient patient;
        String treatmentDetails;
        SNode next;

        SNode(Patient patient, String treatmentDetails) {
            this.patient = patient;
            this.treatmentDetails = treatmentDetails;
            this.next = null;
        }
    }

    private SNode top; // most recently completed treatment
    private int size;

    public TreatmentStack() {
        top = null;
        size = 0;
    }

    // ---------- PUSH ----------
    public void push(Patient patient, String treatmentDetails) {
        SNode newNode = new SNode(patient, treatmentDetails);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Treatment record added for " + patient.getName());
    }

    // ---------- POP ----------
    public void pop() {
        if (isEmpty()) {
            System.out.println("Treatment history is empty. No records to remove.");
            return;
        }

        SNode removed = top;
        top = top.next;
        size--;
        System.out.println("Removed treatment record for " + removed.patient.getName());
    }

    // ---------- DISPLAY ----------
    public void displayTreatments() {
        if (isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }

        System.out.println("Treatment history (most recent first):");
        SNode current = top;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.patient.getName() +
                                " - " + current.treatmentDetails);
            current = current.next;
            count++;
        }
    }

    // ---------- EMPTY CHECK ----------
    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}