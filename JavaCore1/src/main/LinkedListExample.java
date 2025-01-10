package main;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListExample {
    private List<String> students;

    public LinkedListExample() {
        students = new LinkedList<>();
    }

    // Create
    public void addStudent(String student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Read
    public List<String> getStudents() {
        return students;
    }

    // Update
    public void updateStudent(int index, String student) {
        if (index >= 0 && index < students.size()) {
            students.set(index, student);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Index out of bounds");
        }
    }

    // Delete
    public void deleteStudent(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Index out of bounds");
        }
    }

    public static void main(String[] args) {
        LinkedListExample example = new LinkedListExample();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String nameToAdd = scanner.nextLine();
                    example.addStudent(nameToAdd);
                    break;
                case 2:
                    System.out.println("Students: " + example.getStudents());
                    break;
                case 3:
                    System.out.print("Enter index of student to update: ");
                    int indexToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new student name: ");
                    String nameToUpdate = scanner.nextLine();
                    example.updateStudent(indexToUpdate, nameToUpdate);
                    break;
                case 4:
                    System.out.print("Enter index of student to delete: ");
                    int indexToDelete = scanner.nextInt();
                    example.deleteStudent(indexToDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (choice != 5) {
                System.out.print("Do you want to continue? (y/n): ");
                String continueChoice = scanner.nextLine();
                if (!continueChoice.equalsIgnoreCase("y")) {
                    break;
                }
            }
        } while (choice != 5);

        scanner.close();
    }
}