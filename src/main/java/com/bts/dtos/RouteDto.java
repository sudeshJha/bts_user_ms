package com.bts.dtos;

import java.util.List;

import com.bts.models.City;
import com.bts.models.RouteCity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {
	private String title;
	private List<RouteCityDto> routeCities;
}
