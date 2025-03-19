package com.example.EmployeePayrollApp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

import java.util.List;

    @Data
    @ToString
    public class EmployeeDTO {

        @NotEmpty(message = "Name cannot be empty")
        @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is invalid")
        private String name;

        @NotEmpty(message = "Role cannot be empty")
        private String role;  // ✅ Added role field to match Employee entity

        @Min(value = 500, message = "Salary should be more than 500")
        private double salary;

        @NotEmpty(message = "Gender is required")
        private String gender;

        @NotEmpty(message = "Start date is required")
        private String startDate;

        private String note;
        private String profilePic;

        @NotEmpty(message = "Department cannot be empty")
        private List<String> departments; // ✅ Updated to match Employee entity

        // ✅ Default Constructor
        public EmployeeDTO() {}

        // ✅ Constructor with all fields
        public EmployeeDTO(String name, String role, double salary, String gender, String startDate, String note, String profilePic, List<String> departments) {
            this.name = name;
            this.role = role;
            this.salary = salary;
            this.gender = gender;
            this.startDate = startDate;
            this.note = note;
            this.profilePic = profilePic;
            this.departments = departments;
        }
    }