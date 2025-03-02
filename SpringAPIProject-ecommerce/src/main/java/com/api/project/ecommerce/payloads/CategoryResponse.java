package com.api.project.ecommerce.payloads;

import java.util.List;
import jakarta.persistence.Version;

/**
 * The {@code CategoryResponse} class is used to encapsulate paginated responses 
 * for category-related API requests in the E-commerce system.
 *
 * This class contains:
 * - {@code content}: List of category data transfer objects (DTOs).
 * - {@code pageNumber}: The current page number.
 * - {@code pageSize}: Number of records per page.
 * - {@code totalPages}: Total number of pages.
 * - {@code totalElements}: Total number of records.
 * - {@code lastPage}: Indicator of whether it is the last page.
 * - {@code version}: Version number for optimistic locking.
 */
public class CategoryResponse {

    /**
     * List of categories included in the current page.
     */
    private List<CategoryDTO> content;

    /**
     * The current page number in the paginated response.
     */
    private Integer pageNumber;

    /**
     * The number of categories per page.
     */
    private Integer pageSize;

    /**
     * The total number of pages in the paginated result.
     */
    private Integer totalPages;

    /**
     * The total number of category records available.
     */
    private Long totalElements;

    /**
     * Indicates whether this is the last page in the paginated response.
     */
    private boolean lastPage;

    /**
     * Version number for optimistic locking, starting with default value 1.
     */
    @Version
    private Integer version = 1;

    /**
     * Default constructor.
     * Initializes the version to 1.
     */
    public CategoryResponse() {
        this.version = 1;
    }

    /**
     * Parameterized constructor to initialize paginated category response details.
     * 
     * @param content       List of categories.
     * @param pageNumber    Current page number.
     * @param pageSize      Number of records per page.
     * @param totalPages    Total number of pages.
     * @param totalElements Total number of category records.
     * @param lastPage      Indicator of whether this is the last page.
     * @param version       Version number for optimistic locking.
     */
    public CategoryResponse(List<CategoryDTO> content, Integer pageNumber, Integer pageSize, Integer totalPages,
                            Long totalElements, boolean lastPage, Integer version) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.lastPage = lastPage;
        this.version = version;
    }

    /**
     * Gets the list of categories in the response.
     * 
     * @return The list of {@code CategoryDTO}.
     */
    public List<CategoryDTO> getContent() {
        return content;
    }

    /**
     * Sets the list of categories in the response.
     * 
     * @param content List of {@code CategoryDTO}.
     */
    public void setContent(List<CategoryDTO> content) {
        this.content = content;
    }

    /**
     * Gets the current page number.
     * 
     * @return The current page number.
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the current page number.
     * 
     * @param pageNumber The page number to set.
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Gets the number of records per page.
     * 
     * @return The page size.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the number of records per page.
     * 
     * @param pageSize The page size to set.
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the total number of pages in the paginated response.
     * 
     * @return The total number of pages.
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * Sets the total number of pages in the paginated response.
     * 
     * @param totalPages The total number of pages to set.
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * Gets the total number of category records.
     * 
     * @return The total number of category records.
     */
    public Long getTotalElements() {
        return totalElements;
    }

    /**
     * Sets the total number of category records.
     * 
     * @param totalElements The total number of elements to set.
     */
    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    /**
     * Checks whether this is the last page in the response.
     * 
     * @return {@code true} if this is the last page, otherwise {@code false}.
     */
    public boolean isLastPage() {
        return lastPage;
    }

    /**
     * Sets whether this is the last page in the response.
     * 
     * @param lastPage {@code true} if this is the last page, otherwise {@code false}.
     */
    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    /**
     * Gets the version number for optimistic locking.
     * 
     * @return The version number.
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version number for optimistic locking.
     * 
     * @param version The version number to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
