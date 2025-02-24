package com.api.project.ecommerce.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.api.project.ecommerce.payloads.ProductDTO;
import com.api.project.ecommerce.payloads.ProductResponse;
import com.api.project.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/admin/category/{categoryId}/product")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO, @PathVariable Long categoryId) {

		ProductDTO savedProductDTO = productService.addProduct(categoryId, productDTO);

		return new ResponseEntity<>(savedProductDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/public/products")
	public 	ResponseEntity<ProductResponse> getAllProducts(){
		ProductResponse productResponse=productService.getAllProducts();
		return new ResponseEntity<>(productResponse, HttpStatus.OK);	
	}
	
	@GetMapping("/public/category/{categoryId}/products")
	public 	ResponseEntity<ProductResponse> getAllProductsByCategory(@PathVariable Long categoryId){
		ProductResponse productResponse=productService.seachByCategory(categoryId);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);	
	}
	
	@GetMapping("/public/products/keyword/{keyword}")
	public 	ResponseEntity<ProductResponse> getAllProductsByCategoryName(@PathVariable String keyword){
		ProductResponse productResponse=productService.seachProductBykeyword(keyword);
		return new ResponseEntity<>(productResponse, HttpStatus.FOUND);	
	}
	
	
	@PutMapping("/admin/products/{productId}")
	public 	ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long productId){
		ProductDTO updateProductDTO=productService.updateProduct(productDTO,productId);
		return new ResponseEntity<>(updateProductDTO, HttpStatus.OK);	
	}
	
	@DeleteMapping("/admin/products/{productId}")
	public 	ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long productId){
		ProductDTO deleteProductDTO=productService.deleteProduct(productId);
		return new ResponseEntity<>(deleteProductDTO, HttpStatus.OK);	
	}

}
