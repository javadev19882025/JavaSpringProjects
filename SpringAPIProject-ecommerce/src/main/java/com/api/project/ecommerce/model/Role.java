package com.api.project.ecommerce.model;

import jakarta.persistence.*; // Importing JPA annotations
import lombok.*; // Importing Lombok annotations

/**
 * Entity class representing the 'roles' table in the database.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles") // Specifies the table name in the database
public class Role {
    
    /**
     * Primary key for the 'roles' table.
     * Uses GenerationType.IDENTITY for auto-incremented values.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * Enum field to store the role name.
     * The role name is stored as a string in the database.
     * Excluded from the toString() method to avoid unnecessary output.
     */
    @ToString.Exclude
    @Enumerated(EnumType.STRING) // Stores enum values as Strings in the database
    @Column(length = 20, name = "role_name") // Column definition with max length of 20
    private AppRole roleName;

    /**
     * Constructor to initialize the role with a specific role name.
     * 
     * @param roleName The role name as an enum value.
     */
    public Role(AppRole roleName) { 
        this.roleName = roleName;
    }
}
