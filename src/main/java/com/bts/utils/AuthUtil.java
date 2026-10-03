package com.bts.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.bts.models.User;
import com.bts.services.UserService;

@Component
public class AuthUtil {
	
	@Autowired
	private UserService userService;
	
	public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getUserByEmail(email);
    }

    public Long getCurrentUserId() {
        return getCurrentUser().getUserId();
    }
}
