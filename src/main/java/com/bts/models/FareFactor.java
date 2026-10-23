package com.bts.models;

import com.bts.dtos.FareFactorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FareFactor {

	BLANKET_AND_PILLOW("Blanket and Pillow"),
	AIR_CONDITIONER("Air Conditioner"),
	TELIVISION("Telivision"), 
	CHARGING_POINT("Charging Point"),
	EXTRA_LEG_ROOM("Extra Leg Room"),
	RECLINER_SEAT("Recliner Seat"),
	MEAL("Meal");
	
	private  final String label;
	
	public FareFactorDto getDto() {
		FareFactorDto fareFactorDto = new FareFactorDto();
		fareFactorDto.setCode(this.name());
		fareFactorDto.setLabel(this.label);
		
		return fareFactorDto;
	}
}
