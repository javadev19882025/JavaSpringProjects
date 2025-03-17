package com.api.project.ecommerce.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.project.ecommerce.model.CategoryModel;
import com.api.project.ecommerce.model.Product;

/**
 * Repository interface for managing Product entities.
 * Extends JpaRepository to provide basic CRUD operations and pagination support.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Retrieves a paginated list of products belonging to a specific category, 
     * ordered by product price in ascending order.
     *
     * @param categoryModel The category model to filter products.
     * @param pageable      Pagination details.
     * @return A paginated list of products sorted by price in ascending order.
     */
    Page<Product> findByCategoryModelOrderByProductPriceAsc(CategoryModel categoryModel, Pageable pageable);

    /**
     * Retrieves a paginated list of products whose names contain the given keyword,
     * ignoring case sensitivity.
     *
     * @param keyword     The keyword to search for in product names.
     * @param pageDetails Pagination details.
     * @return A paginated list of matching products.
     */
    Page<Product> findByProductNameLikeIgnoreCase(String keyword, Pageable pageDetails);

}
