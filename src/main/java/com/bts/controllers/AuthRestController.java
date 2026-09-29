package com.bts.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.OperatorDto;
import com.bts.dtos.PassengerDto;
import com.bts.dtos.UserDto;
import com.bts.models.Operator;
import com.bts.models.Passenger;
import com.bts.models.User;
import com.bts.services.OperatorService;
import com.bts.services.PassengerService;
import com.bts.services.UserService;

@RestController
public class AuthRestController {

	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private OperatorService operatorService;

	@Autowired
	private  UserService userService;

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


		return ResponseEntity.ok(new ApiResponse<>("Signup Successfull",passengerDto));

	}
	
	@PostMapping("/operator/signup")
	public ResponseEntity<ApiResponse<OperatorDto>> operatorSignup(@ModelAttribute OperatorDto operatorDto) {
		
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
		
		
		BeanUtils.copyProperties(operator, operatorDto);
		
		return ResponseEntity.ok(new ApiResponse<>("Signup Successfull",operatorDto));
	}
	
	@GetMapping("/verify_email")
	public ResponseEntity<ApiResponse<Boolean>> verifyEmail(@RequestParam String verificationCode, 	@RequestParam String email){
		
		
		return null;
	}

}
