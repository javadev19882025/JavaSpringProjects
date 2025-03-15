package com.api.project.ecommerce.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing the User in the e-commerce system.
 * It contains user details, roles, addresses, and associated products.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {

    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    /**
     * Username of the user. Must not be blank and has a maximum length of 25 characters.
     */
    @NotBlank(message = "Username cannot be blank")
    @Size(max = 25, message = "Maximum 25 characters must be entered in the username field")
    @Column(name = "username")
    private String userName;

    /**
     * Email of the user. Must not be blank and has a maximum length of 50 characters.
     */
    @NotBlank(message = "Email cannot be blank")
    @Size(max = 50, message = "Maximum 50 characters must be entered in the Email field")
    @Column(name = "email")
    private String email;

    /**
     * Password of the user. Must not be blank and has a maximum length of 150 characters.
     */
    @NotBlank(message = "Password cannot be blank")
    @Size(max = 150, message = "Maximum 150 characters must be entered in the password field")
    @Column(name = "password")
    private String password;

    /**
     * Constructor to initialize a User with username, email, and password.
     *
     * @param userName the username
     * @param email    the email
     * @param password the password
     */
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    /**
     * Roles assigned to the user.
     * A user can have multiple roles and vice versa (Many-to-Many relationship).
     * Fetch type is set to EAGER to load roles immediately with the user.
     */
    @Setter
    @Getter
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    /**
     * Addresses associated with the user.
     * A user can have multiple addresses and vice versa (Many-to-Many relationship).
     */
    @Getter
    @Setter
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_addresses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses = new ArrayList<>();

    /**
     * Products added by the user.
     * One user can own multiple products (One-to-Many relationship).
     * Orphan removal is enabled to delete products when they are removed from the user.
     */
    @ToString.Exclude
    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Product> products;
}
