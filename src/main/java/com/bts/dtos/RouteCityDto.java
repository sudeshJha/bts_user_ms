package com.bts.dtos;

import com.bts.models.City;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteCityDto {
	
	private Integer stopSequence;
	private Integer distanceFromSource;
	private Integer timeFromSource;
	private String name;
}
