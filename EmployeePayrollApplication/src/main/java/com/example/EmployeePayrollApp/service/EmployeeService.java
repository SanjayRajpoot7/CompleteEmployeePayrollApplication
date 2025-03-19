package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.exception.EmployeeNotFoundException;
import com.example.EmployeePayrollApp.model.Employee;
import com.example.EmployeePayrollApp.repository.EmployeeRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to get all employees
    public List<Employee> getAllEmployees() {
        List<Employee> list = employeeRepository.findAll();
        return list; // This is assuming you're using JpaRepository
    }

    // Method to save an employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // In-memory storage for employee data
    private List<Employee> employees = new ArrayList<>();

    // Constructor to add sample data (optional)
//    public EmployeeService() {
//        employees.add(new Employee(1, "John Doe", "Software Engineer", 75000));
//        employees.add(new Employee(2, "Jane Smith", "HR Manager", 80000));
//        employees.add(new Employee(3, "Jitesh", "Engineer", 65000));
//        employees.add(new Employee(4, "John", "Supervisor", 43000));
//    }


    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }


    // Fetch employee by ID
    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null); // Return null if employee not found
    }

    // Add a new employee
    public Employee createEmployee(Employee employee) {
        // Simulate an auto-incremented ID (in a real-world app, the DB would handle this)
//        int newId = employee.size()+ 1;
        employee.setId(employee.getId());
        employee.add(employee);
        employeeRepository.save(employee);
        return employee;
    }

    // Update an employee's details
    public Employee updateEmployee(int id, Employee employee) {
        // Find the employee to update
        Employee existingEmployee = getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setRole(employee.getRole());
            existingEmployee.setSalary(employee.getSalary());
            return existingEmployee;
        }
        return null; // Return null if employee doesn't exist
    }

    // Delete employee by ID
    public boolean deleteEmployee(int id) {
        Employee employeeToDelete = getEmployeeById(id);
        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            return true;
        }
        return false;
    }
}
