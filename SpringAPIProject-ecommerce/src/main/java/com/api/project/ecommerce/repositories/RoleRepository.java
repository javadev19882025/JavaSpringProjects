package com.api.project.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.ecommerce.model.AppRole;
import com.api.project.ecommerce.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRoleName(AppRole roleUser);


}
