package com.bts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.models.FareFactor;
import com.bts.models.Operator;
import com.bts.models.OperatorFareFactor;

public interface OperatorFareFactorRepo extends JpaRepository<OperatorFareFactor, Long> {

	boolean existsByOperatorAndFareFactor(Operator operator, FareFactor fareFactor);
	
	List<OperatorFareFactor> findAByOperator(Operator operator);

}
