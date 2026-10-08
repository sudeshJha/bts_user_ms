package com.bts.dtos;

import java.util.List;

import com.bts.models.City;
import com.bts.models.RouteMidCity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {
	private Long routeId;
	private String title;
	private Integer distace; 
	private Boolean isActive;
	private City sourceCity;
	private City desinationCity;
	private List<RouteMidCity> routeMidCities;
}
