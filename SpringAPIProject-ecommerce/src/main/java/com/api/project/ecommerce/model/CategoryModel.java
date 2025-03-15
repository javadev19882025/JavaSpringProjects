package com.api.project.ecommerce.model;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
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
    @NotBlank(message = "Category name cannot be blank")
    @Size(min = 2, message = "Minimum 2 characters must be entered in the category name field")
    private String categoryName;

    /**
     * Type of the category. Cannot be blank and must be at least 2 characters long.
     */
    @NotBlank(message = "Category type cannot be blank")
    @Size(min = 2, message = "Minimum 2 characters must be entered in the category type field")
    private String categoryType;

    /**
     * Rate associated with the category. Cannot be null and must be at least 0.
     */
    @NotNull(message = "Category rate cannot be null")
    @Min(value = 0, message = "Category rate must be at least 0")
    private int categoryRate;
    
    /**
     * List of products associated with the category.
     */
    @OneToMany(mappedBy = "categoryModel", cascade = CascadeType.ALL)
    private List<Product> products;

    /**
     * Version field for optimistic locking.
     * Ensures that concurrent updates do not overwrite each other.
     */
    @Version
    private Integer version = 0;
}
