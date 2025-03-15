package com.api.project.ecommerce.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.api.project.ecommerce.payloads.ProductDTO;
import com.api.project.ecommerce.payloads.ProductResponse;

/**
 * Service interface for handling product-related operations in the e-commerce application.
 */
public interface ProductService {

    /**
     * Adds a new product under a specific category.
     *
     * @param categoryId The ID of the category to which the product belongs.
     * @param productDTO The product data transfer object containing product details.
     * @return The created ProductDTO object.
     */
    ProductDTO addProduct(Long categoryId, ProductDTO productDTO);

    /**
     * Retrieves a paginated list of all products with sorting options.
     *
     * @param pageNumber The page number to retrieve.
     * @param pageSize   The number of items per page.
     * @param sortBy     The field by which to sort the results.
     * @param sortOrder  The order of sorting (ASC or DESC).
     * @return A paginated response containing the list of products.
     */
    ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    /**
     * Retrieves products that belong to a specific category with pagination and sorting.
     *
     * @param categoryId The ID of the category.
     * @param pageNumber The page number to retrieve.
     * @param pageSize   The number of items per page.
     * @param sortBy     The field by which to sort the results.
     * @param sortOrder  The order of sorting (ASC or DESC).
     * @return A paginated response containing products in the specified category.
     */
    ProductResponse seachByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    /**
     * Searches for products based on a keyword with pagination and sorting.
     *
     * @param keyword    The keyword to search for in product details.
     * @param pageNumber The page number to retrieve.
     * @param pageSize   The number of items per page.
     * @param sortBy     The field by which to sort the results.
     * @param sortOrder  The order of sorting (ASC or DESC).
     * @return A paginated response containing matching products.
     */
    ProductResponse seachProductBykeyword(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    /**
     * Updates an existing product with new details.
     *
     * @param productDTO The updated product data transfer object.
     * @param productId  The ID of the product to update.
     * @return The updated ProductDTO object.
     */
    ProductDTO updateProduct(ProductDTO productDTO, Long productId);

    /**
     * Deletes a product by its ID.
     *
     * @param productId The ID of the product to delete.
     * @return The deleted ProductDTO object.
     */
    ProductDTO deleteProduct(Long productId);

    /**
     * Updates the image of a specific product.
     *
     * @param productId The ID of the product for which the image is to be updated.
     * @param image     The new product image file.
     * @return The updated ProductDTO object with the new image.
     * @throws IOException If an error occurs during image processing.
     */
    ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}
