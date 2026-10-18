package com.bts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.models.OperatorRoute;
import com.bts.repos.OperatorRouteRepo;

@Service
public class OperatorRouteService {
	
	@Autowired
	private OperatorRouteRepo operatorRouteRepo;
	
	public OperatorRoute addOperatorRoute(OperatorRoute operatorRoute) {
		return operatorRouteRepo.save(operatorRoute);
	}

}
