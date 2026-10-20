package com.bts.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorRouteDto {
	
	private Long operatorRouteId;
	private RouteDto route;
	private Boolean isActive;
	private List<OperatorRouteCityDto> operatorRouteCities;
}
