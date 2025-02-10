package main.java.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmployeeService {
    private List<Employee> employeesArrayList = new ArrayList<>();
    private List<Employee> employeesLinkedList = new LinkedList<>();
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private int autoIncreaseId = 1;

    public Employee create(String name, double salary) {
        Employee employee = new Employee(autoIncreaseId, name, salary);
        autoIncreaseId++;
        employeesArrayList.add(employee);
        employeesLinkedList.add(employee);
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public List<Employee> getAllEmployeesArrayList() {
        return employeesArrayList;
    }

    public List<Employee> getAllEmployeesLinkedList() {
        return employeesLinkedList;
    }

    public Employee getEmployeeById(int id) {
        return employeeMap.get(id);
    }

    public boolean updateEmployee(int id, String name, double salary) {
        Employee employee = employeeMap.get(id);
        if (employee != null) {
            employee.setName(name);
            employee.setSalary(salary);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        Employee employee = employeeMap.get(id);
        if (employee != null) {
            employeesArrayList.remove(employee);
            employeesLinkedList.remove(employee);
            employeeMap.remove(id);
            return true;
        }
        return false;
    }

    public void printDataStructureSizes() {
        System.out.println("ArrayList size: " + employeesArrayList.size());
        System.out.println("LinkedList size: " + employeesLinkedList.size());
        System.out.println("Map size: " + employeeMap.size());
    }
}