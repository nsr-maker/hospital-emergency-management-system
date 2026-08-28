# Mini Hospital Emergency Management System

A Java console application that simulates the management of patients arriving at a hospital — from registration, to emergency treatment, to visit history — using core data structures.

## 📋 Project Overview

This system was developed for **CIT300 - Data Structures and Algorithms** individual mid assignment. It demonstrates the practical implementation of four fundamental data structures within a real-world scenario: hospital emergency management.

## 🗂️ Data Structures Used

| Component | Data Structure | Purpose |
|---|---|---|
| Patient Records | Binary Search Tree (BST) | Store and manage patients keyed by Patient ID, allowing efficient insert, search, delete, and ordered (in-order) display |
| Emergency Patient Queue | Queue (FIFO) | Manage patients waiting for emergency treatment in arrival order |
| Treatment History | Stack (LIFO) | Track completed treatment records, most recent first |
| Patient Visit History | Singly Linked List | Store each patient's individual history of past hospital visits |

## ⚙️ Features

### Patient Records (BST)
- Insert a new patient
- Search for a patient by Patient ID
- Delete a patient
- Display all patients in ascending order of Patient ID (in-order traversal)

### Emergency Patient Queue
- Enqueue a patient into the waiting list
- Dequeue the next patient for treatment
- Display all patients currently waiting
- Handles empty queue gracefully

### Treatment History (Stack)
- Push a completed treatment record
- Pop the most recently completed record
- Display all treatment records
- Handles empty stack gracefully

### Patient Visit History (Singly Linked List)
- Add a new visit to a patient's history
- Remove a visit
- Search for a specific visit
- Display a patient's full visit history

## 🖥️ How to Run

1. Clone the repository:
```bash
   git clone https://github.com/nsr-maker/hospital-emergency-management-system.git
```
2. Open the project in Eclipse (or any Java IDE):
   - File → Open Projects from File System → select the cloned folder
3. Run `Main.java`:
   - Right-click `Main.java` → Run As → Java Application
4. Follow the on-screen menu to interact with the system.

## 📁 Project Structure
## 🧪 Testing

The system was manually tested by running the application and exercising every menu operation (add/search/delete patient, enqueue/dequeue, push/pop treatment, add/remove/search visit history) with sample data. Output screenshots are included in the submission.

## 👩‍💻 Author

Nasra — CIT300, Data Structures and Algorithms

## 📚 Academic Note

This is an individual assignment submitted as part of the CIT300 module. All code was designed, implemented, and tested independently.