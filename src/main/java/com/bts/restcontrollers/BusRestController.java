package com.bts.restcontrollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.dtos.ApiResponse;

@RestController
public class BusRestController {

	@PostMapping("/add_bus")
	public ApiResponse<?> addOperatorBus(){
		
	}
}
