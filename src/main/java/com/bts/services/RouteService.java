package com.bts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.models.Route;
import com.bts.repos.RouteRepo;

@Service
public class RouteService {

	@Autowired
	private RouteRepo routeRepo;
	
	public List<Route> getRoutesBySourceAndDestinationCity(String sourceCity, String destinationCity){
		return routeRepo.findBySourceCityAndDestinationCity(sourceCity, destinationCity);
	}
}
