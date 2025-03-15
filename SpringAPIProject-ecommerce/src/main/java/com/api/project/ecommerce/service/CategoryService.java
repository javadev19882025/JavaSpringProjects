package com.api.project.ecommerce.service;

import java.util.List;
import com.api.project.ecommerce.payloads.CategoryDTO;
import com.api.project.ecommerce.payloads.CategoryResponse;

/**
 * The {@code CategoryService} interface defines the contract for category-related 
 * operations in the e-commerce application.
 * 
 * <p>This interface follows the principle of loose coupling, ensuring that the
 * service implementation can be easily replaced without affecting other 
 * components.</p>
 * 
 * <p>Implementations of this interface should provide the actual logic for these
 * operations.</p>
 */
public interface CategoryService {

    /**
     * Retrieves all categories with pagination and sorting.
     * 
     * @param pageNumber The page number to fetch.
     * @param pageSize The number of records per page.
     * @param sortBy The field by which the results should be sorted.
     * @param sortOrder The sorting order (ascending or descending).
     * @return A {@code CategoryResponse} containing a paginated list of categories.
     */
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    /**
     * Creates a new category in the system.
     * 
     * @param categoryDTO The data transfer object containing category details.
     * @return The created {@code CategoryDTO} object.
     */
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    /**
     * Creates multiple categories in the system.
     * 
     * @param categories A list of category DTOs to be added.
     * @return A list of created {@code CategoryDTO} objects.
     */
    List<CategoryDTO> createMultipleCategories(List<CategoryDTO> categories);

    /**
     * Deletes an existing category by its ID.
     * 
     * @param categoryId The unique ID of the category to be deleted.
     * @return The deleted {@code CategoryDTO} object.
     */
    CategoryDTO removeCategory(Long categoryId);

    /**
     * Updates an existing category.
     * 
     * @param categoryDTO The category data to update.
     * @param categoryId The unique ID of the category to be updated.
     * @return The updated {@code CategoryDTO} object.
     */
    CategoryDTO updatecategory(CategoryDTO categoryDTO, Long categoryId);
}
