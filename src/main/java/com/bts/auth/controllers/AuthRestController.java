package com.bts.auth.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bts.auth.dtos.ApiResponse;
import com.bts.auth.dtos.PassengerDto;
import com.bts.auth.dtos.UserDto;
import com.bts.auth.models.Passenger;
import com.bts.auth.models.User;
import com.bts.auth.services.PassengerService;
import com.bts.auth.services.UserService;

@RestController
public class AuthRestController {
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private  UserService userService;
	
	@GetMapping("/test")
	public String test() {
		return "Testing successful";
	}
	
	@PostMapping("/signup")
	public ResponseEntity<ApiResponse<PassengerDto>> signup(@RequestBody UserDto userDto) {
		
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
		
		PassengerDto passengerDto = new PassengerDto();
		UserDto userInfo = new UserDto();
		
		BeanUtils.copyProperties(passenger.getUser(),userInfo);

		
		passengerDto.setPassengerId(passenger.getPassengerId());
		passengerDto.setUserInfo(userInfo);
		
		ApiResponse<PassengerDto> response = new ApiResponse<PassengerDto>();
		response.setMessage("Signup Successfull");
		response.setResponse(passengerDto);
		
		return ResponseEntity.ok(response);
	}
	
}
