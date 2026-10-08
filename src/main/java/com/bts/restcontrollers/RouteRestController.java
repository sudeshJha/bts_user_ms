package com.bts.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteRestController {
	
	@GetMapping("/city_route")
	public void masterRouteByCity(@RequestParam String sourceCity, @RequestParam String destinationCity) {
		
		if(sourceCity == null || destinationCity == null) {
			
		}
	}

}
