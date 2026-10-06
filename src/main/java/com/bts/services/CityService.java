package com.bts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.models.City;
import com.bts.repos.CityRepo;

@Service
public class CityService {
	
	@Autowired
	private CityRepo cityRepo;
	
	public List<City> getAllCities(){
		return cityRepo.findAll();
	}
}
