package com.einvoice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.einvoice.model.User;



public interface UserRepository extends  CrudRepository<User, Long>, JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
	@Query(value = "select * from users u where u.username = ?1", nativeQuery = true)
	User findByUsernames(String username);
}
