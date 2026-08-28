package hospital;

/**
 * VisitHistoryList implements a Singly Linked List to store
 * a patient's history of previous hospital visits.
 */

public class VisitHistoryList {

    // Node class for singly linked list
    private class LNode {
        Visit visit;
        LNode next;

        LNode(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private LNode head;

    public VisitHistoryList() {
        head = null;
    }

    // ---------- ADD VISIT ----------
    public void addVisit(Visit visit) {
        LNode newNode = new LNode(visit);

        if (head == null) {
            head = newNode;
        } else {
            LNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Visit " + visit.getVisitId() + " added to history.");
    }

    // ---------- REMOVE VISIT ----------
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history to remove from.");
            return;
        }

        // If head itself needs to be removed
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit " + visitId + " removed.");
            return;
        }

        LNode current = head;
        while (current.next != null && current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Visit ID " + visitId + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Visit " + visitId + " removed.");
        }
    }

    // ---------- SEARCH VISIT ----------
    public Visit searchVisit(int visitId) {
        LNode current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null; // not found
    }

    // ---------- DISPLAY VISIT HISTORY ----------
    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.println("Visit history:");
        LNode current = head;
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }
}