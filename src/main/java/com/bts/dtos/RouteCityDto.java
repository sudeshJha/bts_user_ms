package com.bts.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteCityDto {
	
	private Long routeCityId;
	private Integer stopSequence;
	private Integer distanceFromSource;
	private Integer timeFromSource;
	private String name;
}
