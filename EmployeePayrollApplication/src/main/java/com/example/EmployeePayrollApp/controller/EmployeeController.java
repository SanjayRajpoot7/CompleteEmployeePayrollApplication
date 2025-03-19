package com.example.EmployeePayrollApp.controller;

import com.example.EmployeePayrollApp.dto.ResponseDTO;
import com.example.EmployeePayrollApp.model.Employee;
import com.example.EmployeePayrollApp.repository.EmployeeRepository;
import com.example.EmployeePayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/api/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);  // Calls the service
    }

    // Create new employee
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ResponseDTO("Validation Failed", bindingResult.getAllErrors()), HttpStatus.BAD_REQUEST);
        }
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(new ResponseDTO("Employee Created Successfully", createdEmployee), HttpStatus.CREATED);
    }

    // Update existing employee
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable int id, @Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ResponseDTO("Validation Failed", bindingResult.getAllErrors()), HttpStatus.BAD_REQUEST);
        }
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(new ResponseDTO("Employee Updated Successfully", updatedEmployee), HttpStatus.OK);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        return isDeleted ? ResponseEntity.ok("Employee deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
    }


    @GetMapping("/logExample")
    public String logExample() {
        // Log an informational message
        log.info("This is an info log message!");

        // Log a debug message (will only be shown if the debug level is enabled)
        log.debug("This is a debug log message!");

        // Log an error message
        log.error("This is an error log message!");

        return "Logging Example in Spring Boot";
    }
}