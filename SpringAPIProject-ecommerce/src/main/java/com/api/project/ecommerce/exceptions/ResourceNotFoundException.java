package com.api.project.ecommerce.exceptions;

/**
 * Custom exception class for handling resource not found scenarios.
 * 
 * This exception is thrown when a requested resource (such as a user, product, or order)
 * is not found in the database.
 * 
 * It extends {@code RuntimeException}, allowing it to be thrown during runtime without
 * requiring explicit exception handling.
 */
public class ResourceNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = 1L; // Ensures compatibility during serialization

    // Variables to store exception details
    private String resourceName;  // Name of the resource that was not found
    private String field;         // Name of the field used for searching the resource
    private String fieldName;     // Value of the field in case of a String
    private Long fieldId;         // Value of the field in case of an ID (Long)

    /**
     * Default constructor for {@code ResourceNotFoundException}.
     * 
     * This is required for deserialization or when no specific message is needed.
     */
    public ResourceNotFoundException() {
    }

    /**
     * Constructor for {@code ResourceNotFoundException} when the field value is a String.
     * 
     * @param resourceName The name of the resource (e.g., "User", "Product").
     * @param field The name of the field used to find the resource (e.g., "email", "username").
     * @param fieldName The actual value of the field that was searched (e.g., "john@example.com").
     */
    public ResourceNotFoundException(String resourceName, String field, String fieldName) {
        super(String.format("%s not found with %s: %s", resourceName, field, fieldName));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName = fieldName;
    }

    /**
     * Constructor for {@code ResourceNotFoundException} when the field value is an ID.
     * 
     * @param resourceName The name of the resource (e.g., "Order", "Category").
     * @param field The name of the field used to find the resource (e.g., "id").
     * @param fieldId The actual ID value of the field that was searched.
     */
    public ResourceNotFoundException(String resourceName, String field, Long fieldId) {
        super(String.format("%s not found with %s: %d", resourceName, field, fieldId));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;
    }
}
