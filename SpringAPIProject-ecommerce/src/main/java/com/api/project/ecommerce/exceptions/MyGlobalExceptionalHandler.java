package com.api.project.ecommerce.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.project.ecommerce.payloads.APIResponse;

/**
 * Global Exception Handler for handling various types of exceptions across the application.
 * 
 * This class is annotated with {@code @RestControllerAdvice}, which allows it to
 * handle exceptions globally and return appropriate HTTP responses.
 */
@RestControllerAdvice
public class MyGlobalExceptionalHandler {

    /**
     * Handles validation errors when request body validation fails.
     * 
     * This method captures validation errors from {@code @Valid} annotated request bodies
     * and returns a structured error response.
     * 
     * @param e The exception thrown when validation fails.
     * @return A ResponseEntity containing error details and HTTP status 400 (Bad Request).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException e) {
        // Stores field-specific validation errors
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError) err).getField();
            String message = err.getDefaultMessage();
            errors.put(fieldName, message);
        });

        // Constructs a structured error response
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Error");
        response.put("errors", errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles cases where the request body contains invalid JSON.
     * 
     * This exception occurs when the JSON payload is malformed or has incorrect formatting.
     * 
     * @param e The exception thrown when JSON deserialization fails.
     * @return A ResponseEntity with a user-friendly error message and HTTP status 400 (Bad Request).
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidJson(HttpMessageNotReadableException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Invalid JSON format");
        response.put("message", "Check your JSON structure and ensure all required fields are provided.");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles cases where a requested resource is not found.
     * 
     * This method captures {@code ResourceNotFoundException} and returns a structured response
     * with HTTP status 404 (Not Found).
     * 
     * @param e The exception thrown when a resource is not found.
     * @return A ResponseEntity with an error message and HTTP status 404.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> myResourceNotFoundException(ResourceNotFoundException e) {
        String message = e.getMessage();
        APIResponse apiResponse = new APIResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles custom API exceptions.
     * 
     * This method captures {@code APIException}, which is used for handling business logic errors.
     * 
     * @param e The exception thrown for API-specific errors.
     * @return A ResponseEntity containing an error message and HTTP status 400 (Bad Request).
     */
    @ExceptionHandler(APIException.class)
    public ResponseEntity<APIResponse> myAPIException(APIException e) {
        String message = e.getMessage();
        APIResponse apiResponse = new APIResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
