package hospital;

public class PatientBST {

    // Inner class for BST Node
    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    // ---------- INSERT ----------
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node current, Patient patient) {
        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRec(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRec(current.right, patient);
        } else {
            System.out.println("Patient ID " + patient.getPatientId() + " already exists!");
        }

        return current;
    }

    // ---------- SEARCH ----------
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Node current, int patientId) {
        if (current == null) {
            return null; // not found
        }

        if (patientId == current.patient.getPatientId()) {
            return current.patient;
        } else if (patientId < current.patient.getPatientId()) {
            return searchRec(current.left, patientId);
        } else {
            return searchRec(current.right, patientId);
        }
    }

    // ---------- DELETE ----------
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Node deleteRec(Node current, int patientId) {
        if (current == null) {
            System.out.println("Patient ID " + patientId + " not found!");
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteRec(current.left, patientId);
        } else if (patientId > current.patient.getPatientId()) {
            current.right = deleteRec(current.right, patientId);
        } else {
            // Node found - this is the one to delete

            // Case 1: No child
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: One child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // Case 3: Two children
            // Find the smallest value in the right subtree (in-order successor)
            Patient successor = findMin(current.right);
            current.patient = successor;
            current.right = deleteRec(current.right, successor.getPatientId());
        }

        return current;
    }

    private Patient findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.patient;
    }

    // ---------- IN-ORDER TRAVERSAL ----------
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients in the system.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.println(current.patient);
            inOrderRec(current.right);
        }
    }
}