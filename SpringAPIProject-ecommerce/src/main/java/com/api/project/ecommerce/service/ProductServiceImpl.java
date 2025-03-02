package com.api.project.ecommerce.service;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.project.ecommerce.exceptions.APIException;
import com.api.project.ecommerce.exceptions.ResourceNotFoundException;
import com.api.project.ecommerce.model.CategoryModel;
import com.api.project.ecommerce.model.Product;
import com.api.project.ecommerce.payloads.ProductDTO;
import com.api.project.ecommerce.payloads.ProductResponse;
import com.api.project.ecommerce.repository.CategoryRepository;
import com.api.project.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@Override
	public ProductDTO addProduct(Long categoryId, ProductDTO productDTO) {
		if (productDTO == null || productDTO.getProductName() == null || productDTO.getProductName().trim().isEmpty()) {
			throw new APIException("Product name cannot be null or empty!");
		}

		// Fetch the category or throw an exception if not found
		CategoryModel categoryModel = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		// Check if the product already exists in the category
		boolean isProductAlreadyPresent = categoryModel.getProducts().stream()
				.anyMatch(p -> p.getProductName().equalsIgnoreCase(productDTO.getProductName()));

		if (isProductAlreadyPresent) {
			throw new APIException(
					"Product with the name " + productDTO.getProductName() + " already exists in this category!");
		}

		try {
			// Convert DTO to entity
			Product product = modelMapper.map(productDTO, Product.class);
			product.setCategoryModel(categoryModel);
			product.setProductImage("default.png");

			// Calculate special price
			double specialPrice = product.getProductPrice()
					- ((product.getProductDiscount() * 0.01) * product.getProductPrice());
			product.setProductSpecialPrice(specialPrice);

			// Save the product
			Product savedProduct = productRepository.save(product);

			// Convert back to DTO and return
			return modelMapper.map(savedProduct, ProductDTO.class);
		} catch (Exception e) {
			throw new APIException("An error occurred while saving the product. Please check the input data.");
		}
	}

	@Override
	public ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

		Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

		Page<Product> pageProducts = productRepository.findAll(pageDetails);

		List<Product> products = pageProducts.getContent();

		List<ProductDTO> productDTOS = products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.toList();

		if (products.isEmpty()) {
			throw new APIException("No Product Exists...!");
		}

		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(productDTOS);
		productResponse.setPageNumber(pageProducts.getNumber());
		productResponse.setPageSize(pageProducts.getSize());
		productResponse.setTotalElements(pageProducts.getTotalElements());
	    productResponse.setTotalPages(pageProducts.getTotalPages()); 
		productResponse.setLastPage(pageProducts.isLast());
		return productResponse;
	}

	@Override
	public ProductResponse seachByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
	    if (categoryId == null || categoryId <= 0) {
	        throw new APIException("Invalid category ID provided!");
	    }

	    // Fetch the category or throw an exception if not found
	    CategoryModel categoryModel = categoryRepository.findById(categoryId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

	    // Determine sorting order
	    Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
	            ? Sort.by(sortBy).ascending()
	            : Sort.by(sortBy).descending();

	    // Create pageable object
	    Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

	    // Fetch paginated products
	    Page<Product> pageProducts = productRepository.findByCategoryModelOrderByProductPriceAsc(categoryModel, pageDetails);

	    List<Product> products = pageProducts.getContent();

	    if (products.isEmpty()) {
	        throw new APIException(categoryModel.getCategoryName() + " category does not have any products");
	    }

	    // Convert entity list to DTO list
	    List<ProductDTO> productDTOS = products.stream()
	            .map(product -> modelMapper.map(product, ProductDTO.class))
	            .toList();

	    // Create response object
	    ProductResponse productResponse = new ProductResponse();
	    productResponse.setContent(productDTOS);
	    productResponse.setPageNumber(pageProducts.getNumber());
	    productResponse.setPageSize(pageProducts.getSize());
	    productResponse.setTotalElements(pageProducts.getTotalElements());
	    productResponse.setTotalPages(pageProducts.getTotalPages());
	    productResponse.setLastPage(pageProducts.isLast());

	    return productResponse;
	}



	@Override
	public ProductResponse seachProductBykeyword(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
	    if (keyword == null || keyword.trim().isEmpty()) {
	        throw new APIException("Search keyword cannot be null or empty!");
	    }

	    // Determine sorting order
	    Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
	            ? Sort.by(sortBy).ascending()
	            : Sort.by(sortBy).descending();

	    // Create pageable object
	    Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

	    // Fetch paginated products
	    Page<Product> pageProducts = productRepository.findByProductNameLikeIgnoreCase('%' + keyword + '%', pageDetails);
	    
	    List<Product> products = pageProducts.getContent();

	    if (products.isEmpty()) {
	        throw new APIException("No products found matching the keyword: " + keyword);
	    }

	    // Convert entity list to DTO list
	    List<ProductDTO> productDTOS = products.stream()
	            .map(product -> modelMapper.map(product, ProductDTO.class))
	            .toList();

	    // Create response object
	    ProductResponse productResponse = new ProductResponse();
	    productResponse.setContent(productDTOS);
	    productResponse.setPageNumber(pageProducts.getNumber());
	    productResponse.setPageSize(pageProducts.getSize());
	    productResponse.setTotalElements(pageProducts.getTotalElements());
	    productResponse.setTotalPages(pageProducts.getTotalPages());
	    productResponse.setLastPage(pageProducts.isLast());

	    return productResponse;
	}


	@Override
	public ProductDTO updateProduct(ProductDTO productDTO, Long productId) {
		if (productDTO == null) {
			throw new APIException("Product details cannot be null!");
		}
		if (productDTO.getProductName() == null || productDTO.getProductName().trim().isEmpty()) {
			throw new APIException("Product name cannot be null or empty!");
		}
		if (productDTO.getProductDescription() == null || productDTO.getProductDescription().trim().isEmpty()) {
			throw new APIException("Product description cannot be null or empty!");
		}
		if (productDTO.getProductPrice() <= 0) {
			throw new APIException("Product price must be greater than zero!");
		}
		if (productDTO.getProductQuantity() == null || productDTO.getProductQuantity() < 0) {
			throw new APIException("Product quantity cannot be null or negative!");
		}
		if (productDTO.getProductDiscount() < 0 || productDTO.getProductDiscount() > 100) {
			throw new APIException("Product discount must be between 0 and 100!");
		}

		// Fetch product from database
		Product productFromDB = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

		try {
			// Update product details
			productFromDB.setProductName(productDTO.getProductName());
			productFromDB.setProductDescription(productDTO.getProductDescription());
			productFromDB.setProductQuantity(productDTO.getProductQuantity());
			productFromDB.setProductDiscount(productDTO.getProductDiscount());
			productFromDB.setProductPrice(productDTO.getProductPrice());

			// Recalculate the special price
			double specialPrice = productDTO.getProductPrice()
					- ((productDTO.getProductDiscount() * 0.01) * productDTO.getProductPrice());
			productFromDB.setProductSpecialPrice(specialPrice);

			// Save the updated product
			Product savedProduct = productRepository.save(productFromDB);

			return modelMapper.map(savedProduct, ProductDTO.class);
		} catch (Exception e) {
			throw new APIException("An error occurred while updating the product. Please check the input data.");
		}
	}

	@Override
	public ProductDTO deleteProduct(Long productId) {
		Product productFromDB = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

		productRepository.delete(productFromDB);
		return modelMapper.map(productFromDB, ProductDTO.class);
	}

	@Override
	public ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException {
		if (productId == null || productId <= 0) {
			throw new APIException("Invalid product ID provided!");
		}
		if (image == null || image.isEmpty()) {
			throw new APIException("Product image cannot be null or empty!");
		}

		// Fetch the product or throw an exception if not found
		Product productFromDB = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

		try {
			// Upload image and set the filename
			String fileName = fileService.uploadImage(path, image);
			productFromDB.setProductImage(fileName);

			// Save the updated product
			Product updatedProduct = productRepository.save(productFromDB);

			return modelMapper.map(updatedProduct, ProductDTO.class);
		} catch (IOException e) {
			throw new APIException("An error occurred while uploading the product image.");
		} catch (Exception e) {
			throw new APIException("An unexpected error occurred while updating the product image.");
		}
	}

}
