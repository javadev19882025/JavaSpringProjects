//package com.api.project.ecommerce.ServiceImplementation;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.api.project.ecommerce.model.CategoryModel;
//import com.api.project.ecommerce.service.CategoryService;
//
//@Service
//public class CategoryServiceImplementation implements CategoryService {
//
//	// List to store category models
//	private List<CategoryModel> categories = new ArrayList<>();
//
//	// Variable to keep track of the next available ID
//	private Long nextId = 1L;
//
//	/**
//	 * Retrieves all categories stored in the list.
//	 * 
//	 * @return List of all categories
//	 */
//	@Override
//	public List<CategoryModel> getAllCategories() {
//		return categories;
//	}
//
//	/**
//	 * Creates a new category by assigning it a unique ID and adding it to the list.
//	 * 
//	 * @param category The category model to be added
//	 */
//	@Override
//	public void createCategory(CategoryModel category) {
//		category.setCategoryId(nextId++); // Assign a unique ID
//		categories.add(category); // Add category to the list
//	}
//
//	/**
//	 * Removes a category based on the given category ID. If the category is not
//	 * found, throws a ResponseStatusException with HTTP 404.
//	 * 
//	 * @param categoryId The ID of the category to be removed
//	 * @return Success message if removed successfully
//	 */
//	@Override
//	public String removeCategory(Long categoryId) {
//		// Find category by ID, if not found throw exception
//		CategoryModel categoryModel = categories.stream().filter(c -> c.getCategoryId().equals(categoryId)).findFirst()
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found"));
//
//		categories.remove(categoryModel); // Remove the category
//		return "Category with ID " + categoryId + " removed successfully!";
//	}
//
//	/**
//	 * Updates an existing category based on the given category ID. If the category
//	 * is not found, throws a ResponseStatusException with HTTP 404.
//	 * 
//	 * @param categoryModel The updated category details
//	 * @param categoryId    The ID of the category to be updated
//	 * @return The updated category model
//	 */
//	@Override
//	public CategoryModel updatecategory(CategoryModel categoryModel, Long categoryId) {
//		// Find category by ID, if not found throw exception
//		Optional<CategoryModel> optionalCategory = categories.stream().filter(c -> c.getCategoryId().equals(categoryId))
//				.findFirst();
//
//		if (optionalCategory.isPresent()) {
//			CategoryModel existingCategory = optionalCategory.get();
//			existingCategory.setCategoryName(categoryModel.getCategoryName());
//			existingCategory.setCategorytype(categoryModel.getCategorytype());
//			existingCategory.setCategoryrate(categoryModel.getCategoryrate());
//			return existingCategory; // Return updated category
//		} else {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found");
//		}
//	}
//
//	@Override
//	public void createMultipleCategories(List<CategoryModel> categoriesList) {
//		for (CategoryModel categoryModel : categoriesList) {
//			categoryModel.setCategoryId(nextId++); // Assign a unique ID to each category
//			categories.add(categoryModel); // Add each category to the list
//		}
//
//	}
//}
