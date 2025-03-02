package com.api.project.ecommerce.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private Long productId;
	private String productName;
	private String productImage;
	private String productDescription;
	private Integer productQuantity;
	private double productPrice;
	private double productDiscount;
	private double productSpecialPrice;

}
	