package com.api.project.ecommerce.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.api.project.ecommerce.payloads.ProductDTO;
import com.api.project.ecommerce.payloads.ProductResponse;

public interface ProductService {

	ProductDTO addProduct(Long categoryId, ProductDTO productDTO);

	ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	ProductResponse seachByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	ProductResponse seachProductBykeyword(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	ProductDTO updateProduct(ProductDTO productDTO, Long productId);

	ProductDTO deleteProduct(Long productId);

	ProductDTO updateProductImage(Long productId, MultipartFile image)throws IOException;



}
