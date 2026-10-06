package com.bts.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.OperatorDto;
import com.bts.dtos.PassengerDto;
import com.bts.dtos.UserDto;
import com.bts.models.Operator;
import com.bts.models.Passenger;
import com.bts.models.User;
import com.bts.models.UserType;
import com.bts.services.OperatorService;
import com.bts.services.PassengerService;
import com.bts.utils.AuthUtil;

@RestController
public class UserRestController {
	@Autowired 
	private AuthUtil authUtil;
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private OperatorService operatorService;
	
	@GetMapping("/get_user")
	public ResponseEntity<ApiResponse<?>> getCurrentUser() {
	    
	    User user = authUtil.getCurrentUser();
	    
	    if(user == null) {
	    	return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new ApiResponse<>("The user is not registered."));
	    }
	    
	    UserType userType = user.getUserType();
	    
	    if(userType == UserType.OPERATOR) {
	    	Operator operator = operatorService.getOperatorByUserId(user.getUserId());
	    	OperatorDto operatorDto = new OperatorDto();
	    	UserDto userDto = new UserDto();
	    	BeanUtils.copyProperties(user, userDto);
	    	BeanUtils.copyProperties(operator, operatorDto);
	    	operatorDto.setUserInfo(userDto);
	    	
	    	return ResponseEntity.ok(new ApiResponse<OperatorDto>("Succesfully fetched User", operatorDto));
	    }
	    else if(userType == UserType.PASSENGER) {
	    	Passenger passenger = passengerService.getPassengerByUserId(user.getUserId());
	    	PassengerDto passengerDto = new PassengerDto();
	    	UserDto userDto = new UserDto();
	    	BeanUtils.copyProperties(user, userDto);
	    	BeanUtils.copyProperties(passenger, passengerDto);
	    	passengerDto.setUserInfo(userDto);
	    	
	    	return ResponseEntity.ok(new ApiResponse<PassengerDto>("Succesfully fetched User", passengerDto));
	    }
	    else {
	    	return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new ApiResponse<>("Could not get User"));
	    }
	}
}
