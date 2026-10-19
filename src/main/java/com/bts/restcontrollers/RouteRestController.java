package com.bts.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.CityDto;
import com.bts.dtos.OperatorRouteCityDto;
import com.bts.dtos.OperatorRouteDto;
import com.bts.dtos.RouteCityDto;
import com.bts.dtos.RouteDto;
import com.bts.models.Operator;
import com.bts.models.OperatorRoute;
import com.bts.models.OperatorRouteCity;
import com.bts.models.Route;
import com.bts.models.RouteCity;
import com.bts.models.User;
import com.bts.services.OperatorRouteService;
import com.bts.services.OperatorService;
import com.bts.services.RouteService;
import com.bts.services.UserService;

@RestController
public class RouteRestController {

	@Autowired
	private RouteService routeService;
	
	@Autowired 
	private OperatorService operatorService;

	@Autowired
	private OperatorRouteService operatorRouteService;
	
	@GetMapping("/city_route")
	public ApiResponse<?> masterRoutesByCity(@RequestParam String sourceCity, @RequestParam String destinationCity) {

		if (sourceCity == null || destinationCity == null) {
			return new ApiResponse<>("Source and Destination City cannot be empty");
		}

		List<Route> routes = routeService.getRoutesBySourceAndDestinationCity(sourceCity, destinationCity);

		if (routes.isEmpty()) {
			return new ApiResponse<>("There is no matching routes for those cities",routes);
		}

		List<RouteDto> routesDto = new ArrayList<RouteDto>();

		for (Route route : routes) {

			RouteDto routeDto = new RouteDto();
			BeanUtils.copyProperties(route, routeDto);
			List<RouteCityDto> cities = new ArrayList<RouteCityDto>();
			
			boolean isMidCity = false;
			
			for (RouteCity routeCity : route.getRouteCities()) {
				RouteCityDto routeCityDto = new RouteCityDto();
				BeanUtils.copyProperties(routeCity, routeCityDto);
								
				if(routeCity.getCity().getName().equals(sourceCity)) {
					isMidCity = true;
				}
				
				if(isMidCity) {
					routeCityDto.setName(routeCity.getCity().getName());
					cities.add(routeCityDto);
				}
				
				if(routeCity.getCity().getName().equals(destinationCity)) {
					isMidCity = false;
				}
			}
			routeDto.setRouteCities(cities);
			routesDto.add(routeDto);
		}

		return new ApiResponse<>("Successfully fetched routes", routesDto);
	}
	
	@PostMapping("/add_operator_route")
	public ApiResponse<?> addOperatorRoute(@RequestBody OperatorRouteDto operatorRouteDto, Authentication authentication){		
		
		String email = authentication.getName();
		Operator operator = operatorService.getOperatorByEmail(email);
		List<OperatorRouteCity> operatorRouteCities = new ArrayList<>();
		
		OperatorRoute operatorRoute = new OperatorRoute();
		BeanUtils.copyProperties(operatorRouteDto, operatorRoute);
		
		for(OperatorRouteCityDto operatorRouteCityDto : operatorRouteDto.getOperatorRouteCities()) {
			OperatorRouteCity operatorRouteCity = new OperatorRouteCity();
			BeanUtils.copyProperties(operatorRouteCityDto, operatorRouteCity);
			
			operatorRouteCity.setRouteCity(new RouteCity(operatorRouteCityDto.getRouteCity().getRouteCityId()));
			
			operatorRouteCities.add(operatorRouteCity);
		}
		
		operatorRoute.setRoute(new Route(operatorRouteDto.getRoute().getRouteId()));
		operatorRoute.setOperatorRouteCities(operatorRouteCities);
		operatorRoute.setOperator(operator);
		operatorRoute.setIsActive(false);
		
		
		operatorRouteService.addOperatorRoute(operatorRoute);
		
		return new ApiResponse<OperatorRouteDto>("Route addded successfully", operatorRouteDto);
	}

	@GetMapping("/operator_routes")
	public ApiResponse<?> allOperatorRoutes(Authentication authentication){
		
		Operator operator= operatorService.getOperatorByEmail(authentication.getName());
		
		List<OperatorRoute> operatorRoutes = operatorRouteService.getAllOperatorRoutes(operator);
		
		String message = "Successfully fetched operator routes";
		
		if(operatorRoutes.isEmpty()) {
			message = "No Routes found.";
		}
		
		return new ApiResponse<List<OperatorRoute>>(message, operatorRoutes);
		
	}
}
