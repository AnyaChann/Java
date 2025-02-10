package main.java.view;

import java.util.Scanner;
import main.java.controller.EmployeeController;
import main.java.model.Employee;

public class ControlView {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeController employeeController = new EmployeeController();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getValidatedChoice();
            handleChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Create Employee");
        System.out.println("2. Get all Employees (ArrayList)");
        System.out.println("3. Get all Employees (LinkedList)");
        System.out.println("4. Get Employee by ID");
        System.out.println("5. Update Employee");
        System.out.println("6. Delete Employee");
        System.out.println("7. Print Data Structure Sizes");
        System.out.println("8. Exit");
        System.out.print("Choose: ");
    }

    private static int getValidatedChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 8.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                createEmployee();
                break;
            case 2:
                getAllEmployeesArrayList();
                break;
            case 3:
                getAllEmployeesLinkedList();
                break;
            case 4:
                getEmployeeById();
                break;
            case 5:
                updateEmployee();
                break;
            case 6:
                deleteEmployee();
                break;
            case 7:
                printDataStructureSizes();
                break;
            case 8:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    private static void createEmployee() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter salary: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid salary.");
            scanner.next();
        }
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        employeeController.createEmployee(name, salary);
        System.out.println("Employee created successfully.");
    }

    private static void getAllEmployeesArrayList() {
        System.out.println("Employees (ArrayList): ");
        employeeController.getAllEmployeesArrayList().forEach(System.out::println);
    }

    private static void getAllEmployeesLinkedList() {
        System.out.println("Employees (LinkedList): ");
        employeeController.getAllEmployeesLinkedList().forEach(System.out::println);
    }

    private static void getEmployeeById() {
        System.out.print("Enter ID: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid ID.");
            scanner.next();
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Employee employee = employeeController.getEmployeeById(id);
        if (employee != null) {
            System.out.println("Employee: " + employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter ID: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid ID.");
            scanner.next();
        }
        int idUpdate = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new salary: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid salary.");
            scanner.next();
        }
        double newSalary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        boolean success = employeeController.updateEmployee(idUpdate, newName, newSalary);
        if (success) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter ID: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid ID.");
            scanner.next();
        }
        int idDelete = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        boolean success = employeeController.deleteEmployee(idDelete);
        if (success) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void printDataStructureSizes() {
        employeeController.printSizes();
    }
}