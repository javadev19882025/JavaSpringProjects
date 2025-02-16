package com.api.project.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * The {@code CategoryModel} class represents the Category entity in the E-commerce API.
 * 
 * This entity is mapped to the "Categories" table in the database and is used
 * to store details about product categories, including:
 * 
 * - {@code categoryId}: Unique identifier for the category.  
 * - {@code categoryName}: Name of the category (must be at least 2 characters long).  
 * - {@code categoryType}: Type of the category (must be at least 2 characters long).  
 * - {@code categoryRate}: Rate associated with the category (must be non-negative).  
 * - {@code version}: Version field for optimistic locking.
 * 
 * This class includes getter and setter methods to allow controlled access and
 * modification of these attributes.
 */

@Entity
@Table(name = "Categories")
public class CategoryModel {

    /**
     * Unique identifier for the category. Auto-generated using IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    /**
     * Name of the category. Cannot be blank and must be at least 2 characters long.
     */
    @NotBlank
    @Size(min = 2, message = "Minimum 2 characters must be entered in the category name field")
    private String categoryName;

    /**
     * Type of the category. Cannot be blank and must be at least 2 characters long.
     */
    @NotBlank
    @Size(min = 2, message = "Minimum 2 characters must be entered in the category type field")
    private String categorytype;

    /**
     * Rate associated with the category. Cannot be null and must be at least 0.
     */
    @NotNull(message = "Category rate cannot be null")
    @Min(value = 0, message = "Category rate must be at least 0")
    private int categoryrate;

    /**
     * Version field for optimistic locking.
     * Ensures that concurrent updates do not overwrite each other.
     */
    @Version
    private Integer version = 0;

    /**
     * Default constructor initializing the version field.
     */
    public CategoryModel() {
        this.version = 0;
    }

    /**
     * Parameterized constructor for creating a new {@code CategoryModel} instance.
     * 
     * @param categoryId   Unique identifier for the category.
     * @param categoryName Name of the category.
     * @param categorytype Type of the category.
     * @param categoryrate Rate associated with the category.
     */
    public CategoryModel(Long categoryId, String categoryName, String categorytype, int categoryrate) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categorytype = categorytype;
        this.categoryrate = categoryrate;
        this.version = 0;
    }

    /**
     * Gets the category ID.
     * 
     * @return the unique identifier for the category.
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the category ID.
     * 
     * @param categoryId the unique identifier to set.
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets the category name.
     * 
     * @return the name of the category.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the category name.
     * 
     * @param categoryName the name of the category to set.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets the category type.
     * 
     * @return the type of the category.
     */
    public String getCategorytype() {
        return categorytype;
    }

    /**
     * Sets the category type.
     * 
     * @param categorytype the type of the category to set.
     */
    public void setCategorytype(String categorytype) {
        this.categorytype = categorytype;
    }

    /**
     * Gets the category rate.
     * 
     * @return the rate associated with the category.
     */
    public int getCategoryrate() {
        return categoryrate;
    }

    /**
     * Sets the category rate.
     * 
     * @param categoryrate the rate of the category to set.
     */
    public void setCategoryrate(int categoryrate) {
        this.categoryrate = categoryrate;
    }
}
