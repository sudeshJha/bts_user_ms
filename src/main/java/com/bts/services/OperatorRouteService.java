package com.bts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.models.Operator;
import com.bts.models.OperatorRoute;
import com.bts.repos.OperatorRouteRepo;

@Service
public class OperatorRouteService {
	
	@Autowired
	private OperatorRouteRepo operatorRouteRepo;
	
	public OperatorRoute addOperatorRoute(OperatorRoute operatorRoute) {
		return operatorRouteRepo.save(operatorRoute);
	}

	public List<OperatorRoute> getAllOperatorRoutes(Operator operator){
		return operatorRouteRepo.findByOperator(operator);
	}
	
	public OperatorRoute getOperatorRouteById(Long operatorRouteId) {
		Optional<OperatorRoute> opt = operatorRouteRepo.findById(operatorRouteId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		return null;
	}
}
