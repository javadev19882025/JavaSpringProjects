package com.api.project.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents an Address entity in the eCommerce system.
 * This class is mapped to a database table and stores details about user addresses.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	/**
	 * Unique identifier for each address.
	 * Auto-generated using the IDENTITY strategy.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	
	/**
	 * Street information for the address.
	 * Cannot be blank and has a maximum length of 100 characters.
	 */
	@NotBlank(message = "Street cannot be blank")
	@Size(max = 100, message = "Street must contain at max 100 characters")
	@Column(name = "street")
	private String street;
	
	/**
	 * Landmark information to help identify the address.
	 * Cannot be blank and has a maximum length of 100 characters.
	 */
	@NotBlank(message = "Landmark cannot be blank")
	@Size(max = 100, message = "Landmark must contain at max 100 characters")
	@Column(name = "landmark")
	private String landmark;
	
	/**
	 * City where the address is located.
	 * Cannot be blank and has a maximum length of 70 characters.
	 */
	@NotBlank(message = "City cannot be blank")
	@Size(max = 70, message = "City must contain at max 70 characters")
	@Column(name = "city")
	private String city;
	
	/**
	 * State where the address is located.
	 * Cannot be blank and has a maximum length of 200 characters.
	 */
	@NotBlank(message = "State cannot be blank")
	@Size(max = 200, message = "State must contain at max 200 characters")
	@Column(name = "state")
	private String state;
	
	/**
	 * Country where the address is located.
	 * Cannot be blank and has a maximum length of 100 characters.
	 */
	@NotBlank(message = "Country cannot be blank")
	@Size(max = 100, message = "Country must contain at max 100 characters")
	@Column(name = "country")
	private String country;
	
	/**
	 * Zip code for the address.
	 * Cannot be blank and has a maximum length of 10 characters.
	 */
	@NotBlank(message = "Zip code cannot be blank")
	@Size(max = 10, message = "Zip code must contain at max 10 characters")
	@Column(name = "zip_code")
	private String zipCode;
	
	/**
	 * Many-to-Many relationship with the User entity.
	 * A single address can be associated with multiple users.
	 * The relationship is mapped by the "addresses" field in the User entity.
	 */
	@ToString.Exclude
	@ManyToMany(mappedBy = "addresses")
	private List<User> user = new ArrayList<>();
	
	/**
	 * Constructor to initialize an Address object without an ID.
	 *
	 * @param street   Street information
	 * @param landmark Landmark information
	 * @param city     City name
	 * @param state    State name
	 * @param country  Country name
	 * @param zipCode  Zip code
	 */
	public Address(String street, String landmark, String city, String state, String country, String zipCode) {
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

}
