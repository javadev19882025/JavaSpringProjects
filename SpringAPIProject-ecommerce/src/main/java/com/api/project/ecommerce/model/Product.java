package com.api.project.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
    @NotBlank(message = "Product name cannot be blank")
    @Size(min = 3, message = "Product name must contain at least 3 characters")
	private String productName;
	private String productImage;
	
	@NotBlank(message = "Product description cannot be blank")
	@Size(min = 6, message = "Product description must contain at least 6 characters")
	private String productDescription;
	
	
	private Integer productQuantity;
	private double productPrice;
	private double productDiscount;
	private double productSpecialPrice;

	@ManyToOne()
	@JoinColumn(name = "category_id",nullable = false)
	private CategoryModel categoryModel;
	
	

}
