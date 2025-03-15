package com.api.project.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing a Product in the e-commerce system.
 * This class is mapped to the "products" table in the database.
 */
@NoArgsConstructor  // Generates a no-argument constructor
@AllArgsConstructor // Generates an all-arguments constructor
@Getter  // Lombok annotation to generate getter methods
@Setter  // Lombok annotation to generate setter methods
@Data  // Lombok annotation to generate getters, setters, toString, equals, and hashCode
@Entity  // Marks this class as a JPA entity
@Table(name = "products")  // Specifies the database table name
@ToString  // Generates a string representation of the object
public class Product {

    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)  // Automatically generates values for the primary key
    private Long productId;

    @NotBlank(message = "Product name cannot be blank")  // Ensures the product name is not blank
    @Size(min = 3, message = "Product name must contain at least 3 characters")  // Ensures a minimum length for the product name
    private String productName;
    
    private String productImage;  // Stores the product image URL or path

    @NotBlank(message = "Product description cannot be blank")  // Ensures the product description is not blank
    @Size(min = 6, message = "Product description must contain at least 6 characters")  // Ensures a minimum length for the product description
    private String productDescription;

    private Integer productQuantity;  // Stores the available quantity of the product
    private double productPrice;  // Stores the price of the product
    private double productDiscount;  // Stores any applicable discount for the product
    private double productSpecialPrice;  // Stores the special discounted price, if applicable

    @ManyToOne  // Defines a many-to-one relationship with CategoryModel
    @JoinColumn(name = "category_id")  // Specifies the foreign key column for the category
    private CategoryModel categoryModel;

    @ManyToOne  // Defines a many-to-one relationship with User
    @JoinColumn(name = "user_id")  // Specifies the foreign key column for the user who added the product
    private User user;

}
