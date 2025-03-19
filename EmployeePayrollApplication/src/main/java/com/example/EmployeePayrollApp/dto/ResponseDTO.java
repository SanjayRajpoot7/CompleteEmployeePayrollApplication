package com.example.EmployeePayrollApp.dto;

import lombok.Data;
import java.util.List;

@Data // Lombok annotation to generate getters, setters, toString(), equals(), hashCode() methods
public class ResponseDTO {
    private String message;
    private Object data;

    // Constructors for success and error cases
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(String message, List<String> errorMessages) {
        this.message = message;
        this.data = errorMessages;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}