package com.example.EmployeePayrollApp.exception;

public class EmployeeNotFoundException extends RuntimeException {

    // Constructor to pass error message
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

