package com.bts.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.CityDto;
import com.bts.dtos.StateDto;
import com.bts.models.City;
import com.bts.models.State;
import com.bts.services.CityService;
import com.bts.services.StateService;

@RestController
public class LocationRestController {
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private StateService stateService;

	@GetMapping("/cities")
	public ResponseEntity<?> getAllCities() {
		
		List<City> cities = cityService.getAllCities();
		
		List<CityDto> citiesDto = new ArrayList<CityDto>();
		
		BeanUtils.copyProperties(cities, citiesDto);
		
		return ResponseEntity.ok(citiesDto);	
	}
	
	@GetMapping("/states")
	public ResponseEntity<?> getAllStates() {
		
		List<State> states = stateService.getAllStates();
		
		List<StateDto> statesDto = new ArrayList<StateDto>();
		
		BeanUtils.copyProperties(states, statesDto);
		
		return ResponseEntity.ok(statesDto);	
	}
}
