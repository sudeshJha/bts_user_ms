package com.bts.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.BusDto;
import com.bts.models.Bus;
import com.bts.models.Operator;
import com.bts.services.BusService;
import com.bts.services.OperatorService;

@RestController
public class BusRestController {
	
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private BusService busService;

	@PostMapping("/add_bus")
	public ApiResponse<?> addOperatorBus(@ModelAttribute BusDto busDto, Authentication authentication){
		
		Operator operator= operatorService.getOperatorByEmail(authentication.getName());
		
		Bus bus = new  Bus();

        busService.addBus(bus, busDto.getImages(), operator);
        
        return new ApiResponse<>("Bus added successfully");
	}
}
