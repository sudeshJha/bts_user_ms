package com.bts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.models.Operator;
import com.bts.models.Passenger;
import com.bts.models.User;
import com.bts.repos.OperatorRepo;

@Service
public class OperatorService {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private OperatorRepo operatorRepo;
	
	public Operator operatorSignup(Operator operator) {

		User user = userService.userSignup(operator.getUser());
		operator.setUser(user);
		operator = operatorRepo.save(operator);

		return operator;
	} 

}
