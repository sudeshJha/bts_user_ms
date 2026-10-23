package com.bts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bts.models.FareFactor;
import com.bts.models.Operator;
import com.bts.models.OperatorFareFactor;
import com.bts.repos.OperatorFareFactorRepo;

public class OperatorFareFactorService {
	@Autowired
	private OperatorFareFactorRepo operatorFareFactorRepo;

	public OperatorFareFactor add(OperatorFareFactor operatorFareFactor) {
		return operatorFareFactorRepo.save(operatorFareFactor);
	}

	public boolean exists(Operator operator, FareFactor fareFactor) {
		return operatorFareFactorRepo.existsByOperatorAndFareFactor(operator, fareFactor);
	}
	
	public List<OperatorFareFactor> getAllOperatorFareFactors(Operator operator) {
		return operatorFareFactorRepo.findAByOperator(operator);
	}
}
