package com.bts.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.auth.models.Passenger;
import com.bts.auth.models.User;
import com.bts.auth.repos.PassengerRepo;


@Service
public class PassengerService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PassengerRepo passengerRepo;
	
	public Passenger passengerSignup(Passenger passenger) {
			
		User user = userService.userSignup(passenger.getUser());
		passenger.setUser(user);
		passenger = passengerRepo.save(passenger);		
		
		return passenger;
	}

}
