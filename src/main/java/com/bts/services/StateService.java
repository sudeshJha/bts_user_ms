package com.bts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.models.State;
import com.bts.repos.StateRepo;

@Service
public class StateService {
	
	@Autowired
	private StateRepo stateRepo;
	
	public List<State> getAllStates(){
		return stateRepo.findAll();
	}
}
