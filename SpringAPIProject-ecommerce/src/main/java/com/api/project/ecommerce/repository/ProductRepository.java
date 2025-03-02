package com.api.project.ecommerce.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.project.ecommerce.model.CategoryModel;
import com.api.project.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Page<Product> findByCategoryModelOrderByProductPriceAsc(CategoryModel categoryModel, Pageable pageable);

	Page<Product> findByProductNameLikeIgnoreCase(String keyword, Pageable pageDetails);

}
