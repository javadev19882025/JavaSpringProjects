package com.api.project.ecommerce.payloads;

/**
 * The {@code APIResponse} class is a generic response model used in the
 * E-commerce API to send responses back to the client.
 * 
 * This class contains:
 * - {@code message}: A descriptive message about the response.
 * - {@code status}: A boolean indicating the success or failure of the API request.
 * 
 * This class includes a default constructor, a parameterized constructor, and 
 * getter and setter methods for controlled access to its attributes.
 */
public class APIResponse {

    /**
     * A descriptive message about the API response.
     */
    private String message;

    /**
     * Status of the API response: {@code true} indicates success, {@code false} indicates failure.
     */
    private boolean status;

    /**
     * Default constructor.
     * Initializes an empty API response.
     */
    public APIResponse() {
    }

    /**
     * Parameterized constructor to initialize API response with a message and status.
     * 
     * @param message The message describing the API response.
     * @param status  The status of the API response (true for success, false for failure).
     */
    public APIResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    /**
     * Gets the response message.
     * 
     * @return The message associated with the API response.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the response message.
     * 
     * @param message The message to be set for the API response.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Checks the status of the API response.
     * 
     * @return {@code true} if the response indicates success, {@code false} otherwise.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status of the API response.
     * 
     * @param status {@code true} for success, {@code false} for failure.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
