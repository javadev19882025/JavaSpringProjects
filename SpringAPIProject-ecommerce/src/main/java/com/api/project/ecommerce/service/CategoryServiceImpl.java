package com.api.project.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.project.ecommerce.exceptions.APIException;
import com.api.project.ecommerce.exceptions.ResourceNotFoundException;
import com.api.project.ecommerce.model.CategoryModel;
import com.api.project.ecommerce.payloads.CategoryDTO;
import com.api.project.ecommerce.payloads.CategoryResponse;
import com.api.project.ecommerce.repository.CategoryRepository;

/**
 * Implementation of the {@link CategoryService} interface.
 * 
 * <p>This service provides business logic for handling category-related operations,
 * including CRUD operations, pagination, and exception handling.</p>
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Retrieves all categories with pagination and sorting.
     * 
     * @param pageNumber The page number to fetch.
     * @param pageSize The number of records per page.
     * @param sortBy The field by which the results should be sorted.
     * @param sortOrder The sorting order (ascending or descending).
     * @return A {@code CategoryResponse} containing a paginated list of categories.
     * @throws APIException if no categories exist in the system.
     */
    @Override
    public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        // Determine sorting order
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // Create pageable object
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<CategoryModel> categoryPage = categoryRepository.findAll(pageDetails);

        // Extract category data
        List<CategoryModel> categoryModels = categoryPage.getContent();

        // If no categories exist, throw an exception
        if (categoryModels.isEmpty()) {
            throw new APIException("No categories found.");
        }

        // Convert entity list to DTO list
        List<CategoryDTO> categoryDTOS = categoryModels.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();

        // Populate response object
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setLastPage(categoryPage.isLast());

        return categoryResponse;
    }

    /**
     * Creates a new category.
     * 
     * @param categoryDTO The category data to be added.
     * @return The created {@code CategoryDTO} object.
     * @throws APIException if a category with the same name already exists.
     */
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryDTO == null || categoryDTO.getCategoryName() == null || categoryDTO.getCategoryName().trim().isEmpty()) {
            throw new APIException("Category name cannot be null or empty!");
        }

        // Check if category with the same name already exists
        CategoryModel categoryFromDB = categoryRepository.findByCategoryName(categoryDTO.getCategoryName());
        if (categoryFromDB != null) {
            throw new APIException("Category with the name " + categoryDTO.getCategoryName() + " already exists!");
        }

        try {
            // Convert DTO to entity
            CategoryModel categoryModel = modelMapper.map(categoryDTO, CategoryModel.class);

            // Save new category
            CategoryModel savedCategoryModel = categoryRepository.save(categoryModel);

            return modelMapper.map(savedCategoryModel, CategoryDTO.class);
        } catch (Exception e) {
            throw new APIException("An error occurred while saving the category. Please check the input data.");
        }
    }

    /**
     * Creates multiple categories.
     * 
     * @param categoriesList A list of category DTOs to be added.
     * @return A list of created {@code CategoryDTO} objects.
     * @throws APIException if any category with the same name already exists.
     */
    @Override
    public List<CategoryDTO> createMultipleCategories(List<CategoryDTO> categoriesList) {
        List<CategoryDTO> savedCategories = new ArrayList<>();

        for (CategoryDTO categoryDTO : categoriesList) {
            // Convert DTO to entity
            CategoryModel categoryModel = modelMapper.map(categoryDTO, CategoryModel.class);

            // Check if category with the same name exists
            CategoryModel categoryFromDB = categoryRepository.findByCategoryName(categoryModel.getCategoryName());
            if (categoryFromDB != null) {
                throw new APIException(
                        "Category with the name " + categoryModel.getCategoryName() + " already exists!");
            }

            // Save category and convert back to DTO
            CategoryModel savedCategoryModel = categoryRepository.save(categoryModel);
            savedCategories.add(modelMapper.map(savedCategoryModel, CategoryDTO.class));
        }

        return savedCategories;
    }

    /**
     * Deletes an existing category by its ID.
     * 
     * @param categoryId The unique ID of the category to be deleted.
     * @return The deleted {@code CategoryDTO} object.
     * @throws ResourceNotFoundException if the category does not exist.
     */
    @Override
    public CategoryDTO removeCategory(Long categoryId) {
        // Fetch category by ID, throw exception if not found
        CategoryModel categoryModel = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        // Delete category
        categoryRepository.delete(categoryModel);
        return modelMapper.map(categoryModel, CategoryDTO.class);
    }

    /**
     * Updates an existing category.
     * 
     * @param categoryDTO The updated category data.
     * @param categoryId The unique ID of the category to be updated.
     * @return The updated {@code CategoryDTO} object.
     * @throws ResourceNotFoundException if the category does not exist.
     */
    @Override
    public CategoryDTO updatecategory(CategoryDTO categoryDTO, Long categoryId) {
        // Fetch category by ID, throw exception if not found
        CategoryModel savedCategoryModel = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        // Convert DTO to entity and update fields
        CategoryModel categoryModel = modelMapper.map(categoryDTO, CategoryModel.class);
        categoryModel.setCategoryId(categoryId);

        // Save updated category
        savedCategoryModel = categoryRepository.save(categoryModel);
        return modelMapper.map(savedCategoryModel, CategoryDTO.class);
    }
}
