package com.bts.restcontrollers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	public ApiResponse<?> getAllCities() {
		
		List<City> cities = cityService.getAllCities();
		
		List<CityDto> citiesDto = new ArrayList<CityDto>();
		
		for(City city : cities) {
			CityDto cityDto = new CityDto();
			BeanUtils.copyProperties(city, cityDto);
			citiesDto.add(cityDto);
		}
		
		Collections.sort(citiesDto, Comparator.comparing(CityDto::getName, String.CASE_INSENSITIVE_ORDER));
		
		return new ApiResponse<>("Successfully fetched cities.",citiesDto);	
	}
	
	@GetMapping("/states")
	public ApiResponse<?> getAllStates() {
		
		List<State> states = stateService.getAllStates();
		
		List<StateDto> statesDto = new ArrayList<StateDto>();
		
		for(State state : states) {
			StateDto stateDto = new StateDto();
			BeanUtils.copyProperties(state, stateDto);
			statesDto.add(stateDto);
		}
		
		Collections.sort(statesDto, Comparator.comparing(StateDto::getName, String.CASE_INSENSITIVE_ORDER));
		
		
		return new ApiResponse<>("Successfully fetched.",statesDto);	
	}
}
