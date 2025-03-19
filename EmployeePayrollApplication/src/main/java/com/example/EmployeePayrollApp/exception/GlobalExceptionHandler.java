package com.example.EmployeePayrollApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.validation.BindingResult;
import com.example.EmployeePayrollApp.dto.ResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle EmployeeNotFoundException
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ResponseDTO response = new ResponseDTO("Employee Not Found", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Handle other global exceptions here
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleGeneralException(Exception ex) {
        ResponseDTO response = new ResponseDTO("An unexpected error occurred", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}