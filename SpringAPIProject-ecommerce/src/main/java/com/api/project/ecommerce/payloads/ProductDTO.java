package com.api.project.ecommerce.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for Product entity.
 * This class is used to transfer product-related data between different layers of the application.
 * Lombok annotations are used to reduce boilerplate code.
 */
@Data  // Generates getter, setter, toString, equals, and hashCode methods.
@Getter // Explicitly provides getter methods for all fields.
@Setter // Explicitly provides setter methods for all fields.
@NoArgsConstructor // Generates a no-argument constructor.
@AllArgsConstructor // Generates a constructor with all fields as arguments.
public class ProductDTO {

    /** Unique identifier for the product */
    private Long productId;

    /** Name of the product */
    private String productName;

    /** URL or path of the product image */
    private String productImage;

    /** Description of the product */
    private String productDescription;

    /** Available quantity of the product in stock */
    private Integer productQuantity;

    /** Price of the product */
    private double productPrice;

    /** Discount percentage applied to the product */
    private double productDiscount;

    /** Special price of the product after applying discount */
    private double productSpecialPrice;
}
