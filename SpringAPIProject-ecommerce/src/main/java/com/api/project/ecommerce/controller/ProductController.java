package com.api.project.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.project.ecommerce.config.AppConstants;
import com.api.project.ecommerce.payloads.ProductDTO;
import com.api.project.ecommerce.payloads.ProductResponse;
import com.api.project.ecommerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * Adds a new product under a specific category.
	 *
	 * @param productDTO  The product data to be added.
	 * @param categoryId  The ID of the category under which the product is added.
	 * @return ResponseEntity containing the saved product details.
	 */
	@PostMapping("/admin/category/{categoryId}/product")
	public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO, @PathVariable Long categoryId) {
		ProductDTO savedProductDTO = productService.addProduct(categoryId, productDTO);
		return new ResponseEntity<>(savedProductDTO, HttpStatus.CREATED);
	}
	
	/**
	 * Retrieves a paginated list of all available products.
	 *
	 * @param pageNumber The page number for pagination.
	 * @param pageSize   The number of products per page.
	 * @param sortBy     The field by which to sort the products.
	 * @param sortOrder  The sorting order (ascending/descending).
	 * @return ResponseEntity containing a paginated list of products.
	 */
	@GetMapping("/public/products")
	public ResponseEntity<ProductResponse> getAllProducts(
			@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_PRODUCTS_BY, required = false) String sortBy,
			@RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder) {
		
		ProductResponse productResponse = productService.getAllProducts(pageNumber, pageSize, sortBy, sortOrder);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}
	
	/**
	 * Retrieves a paginated list of products under a specific category.
	 *
	 * @param categoryId The ID of the category.
	 * @param pageNumber The page number for pagination.
	 * @param pageSize   The number of products per page.
	 * @param sortBy     The field by which to sort the products.
	 * @param sortOrder  The sorting order (ascending/descending).
	 * @return ResponseEntity containing a paginated list of products for the category.
	 */
	@GetMapping("/public/category/{categoryId}/products")
	public ResponseEntity<ProductResponse> getAllProductsByCategory(@Valid @PathVariable Long categoryId,
			@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_PRODUCTS_BY, required = false) String sortBy,
			@RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder) {
		
		ProductResponse productResponse = productService.seachByCategory(categoryId, pageNumber, pageSize, sortBy, sortOrder);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}
	
	/**
	 * Searches for products by keyword.
	 *
	 * @param keyword    The search keyword.
	 * @param pageNumber The page number for pagination.
	 * @param pageSize   The number of products per page.
	 * @param sortBy     The field by which to sort the products.
	 * @param sortOrder  The sorting order (ascending/descending).
	 * @return ResponseEntity containing a paginated list of matching products.
	 */
	@GetMapping("/public/products/keyword/{keyword}")
	public ResponseEntity<ProductResponse> getAllProductsByCategoryName(@Valid @PathVariable String keyword,
			@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_PRODUCTS_BY, required = false) String sortBy,
			@RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder) {
		
		ProductResponse productResponse = productService.seachProductBykeyword(keyword, pageNumber, pageSize, sortBy, sortOrder);
		return new ResponseEntity<>(productResponse, HttpStatus.FOUND);
	}
	
	/**
	 * Updates an existing product.
	 *
	 * @param productDTO The updated product data.
	 * @param productId  The ID of the product to be updated.
	 * @return ResponseEntity containing the updated product details.
	 */
	@PutMapping("/admin/products/{productId}")
	public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO productDTO, @PathVariable Long productId) {
		ProductDTO updateProductDTO = productService.updateProduct(productDTO, productId);
		return new ResponseEntity<>(updateProductDTO, HttpStatus.OK);
	}
	
	/**
	 * Deletes a product by its ID.
	 *
	 * @param productId The ID of the product to be deleted.
	 * @return ResponseEntity containing the deleted product details.
	 */
	@DeleteMapping("/admin/products/{productId}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long productId) {
		ProductDTO deleteProductDTO = productService.deleteProduct(productId);
		return new ResponseEntity<>(deleteProductDTO, HttpStatus.OK);
	}
	
	/**
	 * Updates the image of an existing product.
	 *
	 * @param productId The ID of the product whose image is to be updated.
	 * @param image     The new image file for the product.
	 * @return ResponseEntity containing the updated product details.
	 * @throws IOException If an error occurs during image processing.
	 */
	@PutMapping("/products/{productId}/image")
	public ResponseEntity<ProductDTO> updateProductImage(@Valid @PathVariable Long productId,
			@RequestParam("image") MultipartFile image) throws IOException {
		
		ProductDTO updateProduct = productService.updateProductImage(productId, image);
		return new ResponseEntity<>(updateProduct, HttpStatus.OK);
	}

}
