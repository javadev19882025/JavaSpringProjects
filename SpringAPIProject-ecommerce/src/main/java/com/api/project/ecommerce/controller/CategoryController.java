package com.api.project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.project.ecommerce.config.AppConstants;
import com.api.project.ecommerce.payloads.CategoryDTO;
import com.api.project.ecommerce.payloads.CategoryResponse;
import com.api.project.ecommerce.service.CategoryService;

import jakarta.validation.Valid;

/**
 * CategoryController handles API requests related to product categories.
 * 
 * This controller provides endpoints to: - Retrieve all categories (with
 * pagination and sorting). - Create a single or multiple categories. - Delete a
 * category by ID. - Update an existing category.
 * 
 * The endpoints are categorized as: - Public API: Accessible to all users. -
 * Admin API: Requires admin privileges.
 */
@RestController
@RequestMapping("/api/v1")
public class CategoryController {

	/**
	 * Service layer dependency for handling category-related operations. It is
	 * injected using @Autowired annotation to ensure loose coupling.
	 */
	@Autowired
	private CategoryService categoryService;

	/**
	 * Retrieves all available categories with optional pagination and sorting.
	 * 
	 * @param pageNumber Page number for pagination (default: 0).
	 * @param pageSize   Number of items per page (default: 50).
	 * @param sortBy     Field to sort categories by (default: categoryId).
	 * @param sortOrder  Sorting order: 'asc' (ascending) or 'desc' (descending).
	 * @return A paginated response containing category details.
	 */
	@GetMapping("/public/categories")
	public ResponseEntity<CategoryResponse> getAllCategories(
			@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_CATEGORIES_BY, required = false) String sortBy,
			@RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder) {

		CategoryResponse categoryResponse = categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortOrder);
		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
	}

	/**
	 * Creates a new category.
	 * 
	 * @param categoryDTO The category details provided in the request body.
	 * @return The created category object.
	 */
	@PostMapping("/admin/createcategory")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
		CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
		return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
	}

	/**
	 * Creates multiple categories in a single request.
	 * 
	 * @param categoriesList A list of category objects to be created.
	 * @return A list of created category objects.
	 */
	@PostMapping("/admin/createcategories")
	public ResponseEntity<List<CategoryDTO>> createMultipleCategories(
			@Valid @RequestBody List<CategoryDTO> categoriesList) {
		List<CategoryDTO> savedCategories = categoryService.createMultipleCategories(categoriesList);
		return new ResponseEntity<>(savedCategories, HttpStatus.CREATED);
	}

	/**
	 * Deletes a category based on the provided category ID.
	 * 
	 * @param categoryId The ID of the category to be deleted.
	 * @return The details of the deleted category.
	 */
	@DeleteMapping("/admin/deletecategory/{categoryId}")
	public ResponseEntity<CategoryDTO> removeCategory(@PathVariable Long categoryId) {
		CategoryDTO deletedCategory = categoryService.removeCategory(categoryId);
		return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
	}

	/**
	 * Updates an existing category with the provided details.
	 * 
	 * @param categoryId  The ID of the category to be updated.
	 * @param categoryDTO The updated category details.
	 * @return The updated category object.
	 */
	@PutMapping("/admin/putcategories/{categoryId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
			@PathVariable Long categoryId) {
		CategoryDTO savedCategoryDTO = categoryService.updatecategory(categoryDTO, categoryId);
		return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
	}
}
