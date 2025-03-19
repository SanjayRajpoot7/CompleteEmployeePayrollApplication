package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.model.Employee;

import java.util.List;

public interface InterfaceEmployeePayrollService {
    List<Employee> getEmployeePayrollData();

    Employee getEmployeePayrollDataById(int empid);

    Employee createEmployeePayrollData(EmployeeDTO empPayrollDTO);

    Employee updateEmployeePayrollData(int id , EmployeeDTO employeePayrollDTO);

    // EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
    void deleteEmployeePayrollData(int empId);
}
