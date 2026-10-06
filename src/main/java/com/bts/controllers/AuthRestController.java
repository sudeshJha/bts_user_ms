package com.bts.controllers;

import java.net.URI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.AuthResponse;
import com.bts.dtos.OperatorAuthDto;
import com.bts.dtos.OperatorDto;
import com.bts.dtos.PassengerDto;
import com.bts.dtos.UserAuthDto;
import com.bts.dtos.UserDto;
import com.bts.models.Operator;
import com.bts.models.Passenger;
import com.bts.models.Status;
import com.bts.models.User;
import com.bts.models.UserType;
import com.bts.security.JwtService;
import com.bts.services.OperatorService;
import com.bts.services.PassengerService;
import com.bts.services.UserService;
import com.bts.utils.AuthUtil;

@RestController
public class AuthRestController {

	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private OperatorService operatorService;

	@Autowired
	private  UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	
	
	

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse<?>> signup(@RequestBody UserAuthDto userDto) {
		
		if(userService.checkEmailExist(userDto.getEmail())) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(new ApiResponse<>("Email is already registered",null));

		}

		if(userService.checkPhoneExist(userDto.getPhone())) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(new ApiResponse<>("Phone is already registered",null));
		}

		Passenger passenger = new Passenger();
		User user = new User();
		
		BeanUtils.copyProperties(userDto, user);
		passenger.setUser(user);
		
		passenger = passengerService.passengerSignup(passenger);


		return ResponseEntity.ok(new ApiResponse<>("Signup Successfull"));

	}
	
	@PostMapping("/operator/signup")
	public ResponseEntity<ApiResponse<?>> operatorSignup(@ModelAttribute OperatorAuthDto operatorDto) {
		
		if(userService.checkEmailExist(operatorDto.getUserInfo().getEmail())) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(new ApiResponse<>("Email is already registered",null));

		}

		if(userService.checkPhoneExist(operatorDto.getUserInfo().getPhone())) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(new ApiResponse<>("Phone is already registered",null));
		}
		
		if(operatorDto.getLicense() == null || operatorDto.getLicense().isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(new ApiResponse<>("License could not be processed",null));
		}
		
		Operator operator = new Operator();
		BeanUtils.copyProperties(operatorDto, operator);
		
		User user = new User();
		BeanUtils.copyProperties(operatorDto.getUserInfo(), user);
		
		
		operator.setUser(user);
		operator = operatorService.operatorSignup(operator, operatorDto.getLicense(), operatorDto.getBanner());
		
				
		return ResponseEntity.ok(new ApiResponse<>("Signup Successfull"));
	}
	
	@GetMapping("/verify_user")
	public ResponseEntity<Void> verifyEmail(@RequestParam String verificationCode, 	@RequestParam String email){
		
		boolean verification = userService.verifyUser(email, verificationCode);
		
		if(!verification) {
			return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("http://localhost:5173/signup"))
                    .build();
		}
		
		return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("http://localhost:5173/home"))
                .build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<?>> login(@RequestBody UserAuthDto userDto){
		User user = userService.getUserByEmail(userDto.getEmail());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse<>("This email is not registered.")); 
        }

        if (user.getStatus() == Status.INACTIVE) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse<>("Please verify your account to login")); 
        }

        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse<>("Either email or password is invalid"));
        }

        String token = jwtService.generateToken(userDto.getEmail());
        System.out.println(token);
        return ResponseEntity.ok(new ApiResponse<>("Login successful.",new AuthResponse(token)));
	}

}
