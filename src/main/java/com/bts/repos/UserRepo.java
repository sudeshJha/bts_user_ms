package com.bts.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bts.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);
	boolean existsByPhone(String phone);
	
	User getByEmail(String email);
	
	Optional<User> findByEmail(String email);
}
