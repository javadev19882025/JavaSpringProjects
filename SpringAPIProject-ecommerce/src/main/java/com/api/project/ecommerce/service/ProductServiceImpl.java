package com.api.project.ecommerce.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public ProductDTO addProduct(Long categoryId, ProductDTO productDTO) {

		CategoryModel categoryModel = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		Product product = modelMapper.map(productDTO, Product.class);

		product.setCategoryModel(categoryModel);

		product.setProductImage("default.png");

		double specialPrice = product.getProductPrice()
				- ((product.getProductDiscount() * 0.01) * product.getProductPrice());

		product.setProductSpecialPrice(specialPrice);

		Product savedProduct = productRepository.save(product);

		return modelMapper.map(savedProduct, ProductDTO.class);
	}

	@Override
	public ProductResponse getAllProducts() {

		List<Product> products = productRepository.findAll();

		List<ProductDTO> productDTOS = products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.toList();

		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(productDTOS);

		return productResponse;
	}

	@Override
	public ProductResponse seachByCategory(Long categoryId) {

		CategoryModel categoryModel = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		List<Product> products = productRepository.findByCategoryModelOrderByProductPriceAsc(categoryModel);

		List<ProductDTO> productDTOS = products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.toList();

		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(productDTOS);

		return productResponse;

	}

	@Override
	public ProductResponse seachProductBykeyword(String keyword) {

		List<Product> products = productRepository.findByProductNameLikeIgnoreCase('%' + keyword + '%');

		List<ProductDTO> productDTOS = products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.toList();

		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(productDTOS);

		return productResponse;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO, Long productId) {

		Product productFromDB = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
		
		Product product = modelMapper.map(productDTO, Product.class);

		productFromDB.setProductName(product.getProductName());
		productFromDB.setProductDescription(product.getProductDescription());
		productFromDB.setProductQuantity(product.getProductQuantity());
		productFromDB.setProductDiscount(product.getProductDiscount());
		productFromDB.setProductPrice(product.getProductPrice());
		productFromDB.setProductSpecialPrice(product.getProductSpecialPrice());

		Product savedProduct = productRepository.save(productFromDB);

		return modelMapper.map(savedProduct, ProductDTO.class);
	}

	@Override
	public ProductDTO deleteProduct(Long productId) {
		Product productFromDB = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

		productRepository.delete(productFromDB);
		return modelMapper.map(productFromDB, ProductDTO.class);
	}

}
