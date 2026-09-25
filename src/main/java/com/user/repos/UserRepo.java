package com.user.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);
	boolean existsByPhone(String phone);
}
