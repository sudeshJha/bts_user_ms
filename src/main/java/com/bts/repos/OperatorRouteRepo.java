package com.bts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.models.Operator;
import com.bts.models.OperatorRoute;

public interface OperatorRouteRepo extends JpaRepository<OperatorRoute, Long>{
	
	public List<OperatorRoute> findByOperator(Operator operator);
}
