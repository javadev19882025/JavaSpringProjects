package com.api.project.ecommerce.service;

import com.api.project.ecommerce.payloads.ProductDTO;
import com.api.project.ecommerce.payloads.ProductResponse;

public interface ProductService {

	ProductDTO addProduct(Long categoryId, ProductDTO productDTO);

	ProductResponse getAllProducts();

	ProductResponse seachByCategory(Long categoryId);

	ProductResponse seachProductBykeyword(String keyword);

	ProductDTO updateProduct(ProductDTO productDTO, Long productId);

	ProductDTO deleteProduct(Long productId);

}
