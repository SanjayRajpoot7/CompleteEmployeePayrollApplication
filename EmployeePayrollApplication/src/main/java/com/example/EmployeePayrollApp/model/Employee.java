package com.example.EmployeePayrollApp.model;

import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employeeTable")
public @Data class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name can only contain letters and spaces")
    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String role;

    @Column(name = "salary")
    private double salary;

    @Column(name = "gender")
    private String gender;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "note")
    private String note;

    @Column(name = "profile_pic")
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private List<String> departments;

    // ✅ Default Constructor
    public Employee() {}

    // ✅ Constructor for EmployeeDTO
    public Employee(int id, EmployeeDTO employeeDTO) {
        this.id = id;
        this.name = employeeDTO.getName();
        this.role = employeeDTO.getRole();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.note = employeeDTO.getNote();
        this.startDate = LocalDate.parse(employeeDTO.getStartDate());
        this.profilePic = employeeDTO.getProfilePic();
        this.departments = employeeDTO.getDepartments(); // Ensure it's a List<String>
    }

    // ✅ Constructor for Creating Employee Object
    public Employee(int id, String name, String role, double salary, String gender, String startDate, List<String> departments) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.gender = gender;
        this.startDate = LocalDate.parse(startDate);
        this.departments = departments;
    }

    public void addDepartments(List<String> newDepartments) {
        if (newDepartments != null && !newDepartments.isEmpty()) {
            this.departments.addAll(newDepartments);
        } else {
            throw new IllegalArgumentException("Department list cannot be null or empty");
        }
    }

    public void addDepartment(String department) {
        if (department != null && !department.isEmpty()) {
            this.departments.add(department);
        } else {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }
    }

}