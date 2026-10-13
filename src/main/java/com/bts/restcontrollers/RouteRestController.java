package com.bts.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.CityDto;
import com.bts.dtos.RouteCityDto;
import com.bts.dtos.RouteDto;
import com.bts.models.Route;
import com.bts.models.RouteCity;
import com.bts.services.RouteService;

@RestController
public class RouteRestController {

	@Autowired
	private RouteService routeService;

	@GetMapping("/city_route")
	public ApiResponse<?> masterRouteByCity(@RequestParam String sourceCity, @RequestParam String destinationCity) {

		if (sourceCity == null || destinationCity == null) {
			return new ApiResponse<>("Source and Destination City cannot be empty");
		}

		List<Route> routes = routeService.getRoutesBySourceAndDestinationCity(sourceCity, destinationCity);

		if (routes.isEmpty()) {
			return new ApiResponse<>("There is no matching routes for those cities");
		}

		List<RouteDto> routesDto = new ArrayList<RouteDto>();

		for (Route route : routes) {

			RouteDto routeDto = new RouteDto();
			BeanUtils.copyProperties(route, routeDto);
			List<RouteCityDto> cities = new ArrayList<RouteCityDto>();
			
			for (RouteCity routeCity : route.getRouteCities()) {
				RouteCityDto routeCityDto = new RouteCityDto();
				BeanUtils.copyProperties(routeCity, routeCityDto);
				
				routeCityDto.setName(routeCity.getCity().getName());
				cities.add(routeCityDto);
			}
			routeDto.setRouteCities(cities);
			routesDto.add(routeDto);
		}

		return new ApiResponse<>("Successfully fetched routes", routesDto);
	}

}
