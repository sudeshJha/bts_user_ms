package com.bts.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.bts.repos.UserRepo;

@Service
public class AuthService {
	private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepo userRepo;
}
