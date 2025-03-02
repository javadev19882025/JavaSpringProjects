package com.api.project.ecommerce.payloads;

import jakarta.persistence.Version;

/**
 * The {@code CategoryDTO} class is a Data Transfer Object (DTO) used to
 * transfer category-related data between the client and the server in the
 * E-commerce API.
 * 
 * This class contains:
 * - {@code categoryId}: Unique identifier for the category.
 * - {@code categoryName}: Name of the category.
 * - {@code categorytype}: Type of the category.
 * - {@code categoryrate}: Rate associated with the category.
 * - {@code version}: Version number for optimistic locking.
 * 
 * DTOs are typically used to avoid exposing entity models directly in the API
 * responses.
 */
public class CategoryDTO {

    /**
     * Unique identifier for the category.
     */
    private Long categoryId;

    /**
     * Name of the category.
     */
    private String categoryName;

    /**
     * Type of the category.
     */
    private String categorytype;

    /**
     * Rate associated with the category.
     */
    private int categoryrate;

    /**
     * Version number for optimistic locking.
     */
    @Version
    private Integer version = 0;

    /**
     * Default constructor.
     * Initializes the version to 0.
     */
    public CategoryDTO() {
        this.version = 0;
    }

    /**
     * Parameterized constructor to initialize category details.
     * 
     * @param categoryId   The unique identifier for the category.
     * @param categoryName The name of the category.
     * @param categorytype The type of the category.
     * @param categoryrate The rate associated with the category.
     */
    public CategoryDTO(Long categoryId, String categoryName, String categorytype, int categoryrate) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categorytype = categorytype;
        this.categoryrate = categoryrate;
    }

    /**
     * Gets the category ID.
     * 
     * @return The unique identifier of the category.
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the category ID.
     * 
     * @param categoryId The unique identifier to set.
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets the category name.
     * 
     * @return The name of the category.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the category name.
     * 
     * @param categoryName The name of the category to set.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets the category type.
     * 
     * @return The type of the category.
     */
    public String getCategorytype() {
        return categorytype;
    }

    /**
     * Sets the category type.
     * 
     * @param categorytype The type of the category to set.
     */
    public void setCategorytype(String categorytype) {
        this.categorytype = categorytype;
    }

    /**
     * Gets the category rate.
     * 
     * @return The rate associated with the category.
     */
    public int getCategoryrate() {
        return categoryrate;
    }

    /**
     * Sets the category rate.
     * 
     * @param categoryrate The rate of the category to set.
     */
    public void setCategoryrate(int categoryrate) {
        this.categoryrate = categoryrate;
    }
}
