package com.bts.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorRouteCityDto {
	private Long operatorRouteCityId;
	private Integer haltTime;
	private RouteCityDto routeCity;
}
