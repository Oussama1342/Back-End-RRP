package com.erp.project.security.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
 
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
	
	@Query("SELECT u.bureau FROM User u WHERE u.username = ?1")
	public String findBureau(String username);
}
