package main.java.controller;

import java.util.List;
import main.java.model.Employee;
import main.java.model.EmployeeService;

public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController() {
        this.service = new EmployeeService();
    }

    public Employee createEmployee(String name, double salary) {
        return service.create(name, salary);
    }

    public List<Employee> getAllEmployeesArrayList() {
        return service.getAllEmployeesArrayList();
    }

    public List<Employee> getAllEmployeesLinkedList() {
        return service.getAllEmployeesLinkedList();
    }

    public Employee getEmployeeById(int id) {
        return service.getEmployeeById(id);
    }

    public boolean updateEmployee(int id, String newName, double newSalary) {
        return service.updateEmployee(id, newName, newSalary);
    }

    public boolean deleteEmployee(int id) {
        return service.deleteEmployee(id);
    }

    public void printSizes() {
        service.printDataStructureSizes();
    }
}