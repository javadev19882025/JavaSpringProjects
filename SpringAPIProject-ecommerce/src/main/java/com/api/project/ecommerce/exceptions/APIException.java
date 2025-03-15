package com.api.project.ecommerce.exceptions;

/**
 * Custom exception class for handling API-specific errors.
 * 
 * This exception extends {@code RuntimeException}, allowing it to be thrown
 * without requiring explicit handling. It is used to signal issues specific 
 * to the API, such as validation failures, unauthorized access, or invalid operations.
 * 
 * It provides:
 * - A default constructor for generic API errors.
 * - A parameterized constructor to specify custom error messages.
 */
public class APIException extends RuntimeException {

    // Unique identifier for serialization, ensuring class compatibility during deserialization.
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor for APIException.
     * Can be used when no specific error message is required.
     */
    public APIException() {
        super();
    }

    /**
     * Constructor with a custom error message.
     * 
     * @param message A descriptive error message explaining the exception.
     */
    public APIException(String message) {
        super(message);
    }
}
