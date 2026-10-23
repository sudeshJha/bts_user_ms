package com.bts.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.FareFactorDto;
import com.bts.dtos.OperatorFareFactorDto;
import com.bts.models.FareFactor;
import com.bts.models.Operator;
import com.bts.models.OperatorFareFactor;
import com.bts.services.OperatorFareFactorService;
import com.bts.services.OperatorService;

@RestController
public class FareFactorRestController {
	
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private OperatorFareFactorService operatorFareFactorService;
	
	@GetMapping("/fare_factors")
	public ApiResponse<List<FareFactorDto>> allFareFactors(){
		List<FareFactorDto> fareFactorsDto = new ArrayList<>();

	    for (FareFactor fareFactor : FareFactor.values()) {
	    	fareFactorsDto.add(FareFactorDto.getDto(fareFactor));
	    }

	    return new ApiResponse<>("Successfully fetched fare factors", fareFactorsDto);
	}
	
	@GetMapping("/operator_fare_factors")
	public ApiResponse<List<OperatorFareFactorDto>> allOperatorFareFactors(Authentication authentication){
		
		Operator operator= operatorService.getOperatorByEmail(authentication.getName());
		
		List<OperatorFareFactor> operatorFareFactors = operatorFareFactorService.getAllOperatorFareFactors(operator);
		List<OperatorFareFactorDto> operatorFareFactorsDto = new ArrayList<>();

		if(operatorFareFactors.isEmpty()) {
			return new ApiResponse<>("There are no fare factors to this operator",operatorFareFactorsDto);
		
		}
		
		
		for(OperatorFareFactor operatorFareFactor : operatorFareFactors) {
			operatorFareFactorsDto.add(operatorFareFactor.getDto());
		}
		
		return new ApiResponse<>("Successfully fetched Operator Fare Factors",operatorFareFactorsDto);
	}
	
	@PostMapping("/add_operator_fare_factor")
	public ApiResponse<?> addOperatorFareFactor(@RequestBody OperatorFareFactorDto operatorFareFactorDto, Authentication authentication){
		if (operatorFareFactorDto.getFareFactor() == null || operatorFareFactorDto.getPrice() == null || operatorFareFactorDto.getPrice() <= 0) {
			return new ApiResponse<>("Fare factor and a price greater than 0 are required");
		}
		
		FareFactor fareFactor;
		try {
			fareFactor = FareFactor.valueOf(operatorFareFactorDto.getFareFactor().getCode());
		} catch (IllegalArgumentException e) {
			return new ApiResponse<>("Invalid fare factor");
		}
		
		Operator operator= operatorService.getOperatorByEmail(authentication.getName());
		
		OperatorFareFactor operatorFareFactor = new OperatorFareFactor();
		operatorFareFactor.setPrice(operatorFareFactorDto.getPrice());
		operatorFareFactor.setOperator(operator);
		operatorFareFactor.setFareFactor(fareFactor);
		
		operatorFareFactorService.add(operatorFareFactor);
		
		return new ApiResponse<OperatorFareFactorDto>("Fare factor added successfully");
	}
	
	
}
