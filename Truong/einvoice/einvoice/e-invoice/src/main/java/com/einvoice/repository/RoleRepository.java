package com.einvoice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einvoice.model.Role;
import com.einvoice.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName name);
}
