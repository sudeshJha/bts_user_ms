package com.bts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.models.Passenger;
import com.bts.models.User;
import com.bts.models.UserType;
import com.bts.repos.PassengerRepo;


@Service
public class PassengerService {

	@Autowired
	private UserService userService;

	@Autowired
	private PassengerRepo passengerRepo;

	public Passenger passengerSignup(Passenger passenger) {

		passenger.getUser().setUserType(UserType.PASSENGER);
		User user = userService.userSignup(passenger.getUser());
		passenger.setUser(user);
		passenger = passengerRepo.save(passenger);

		return passenger;
	}

}
