package com.api.project.ecommerce.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ProductResponse is a DTO (Data Transfer Object) that encapsulates
 * the paginated response for product data.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {

    /**
     * A list containing the product data for the current page.
     */
    private List<ProductDTO> content;

    /**
     * The current page number in the paginated response.
     */
    private Integer pageNumber;

    /**
     * The number of items per page.
     */
    private Integer pageSize;

    /**
     * The total number of products available.
     */
    private Long totalElements;

    /**
     * The total number of pages in the paginated response.
     */
    private Integer totalPages;

    /**
     * Indicates whether this is the last page of the result set.
     */
    private boolean lastPage;
}
