package com.api.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.project.ecommerce.model.CategoryModel;

/**
 * The {@code CategoryRepository} interface is responsible for handling database operations
 * related to the {@code CategoryModel} entity.
 * 
 * This repository extends {@code JpaRepository}, providing built-in CRUD operations 
 * and additional query capabilities for managing categories in the E-commerce system.
 */
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    /**
     * Retrieves a category entity based on the category name.
     * 
     * @param categoryName The name of the category to be searched.
     * @return The {@code CategoryModel} object corresponding to the given category name,
     *         or {@code null} if no matching category is found.
     */
    CategoryModel findByCategoryName(String categoryName);
}

