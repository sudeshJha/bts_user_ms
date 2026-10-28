package com.bts.models;

import com.bts.dtos.BusCategoryDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BusCategory {  
	SLEEPER("Sleeper"),
	SEATER("Seater"),
	SEMI_SLEEPER("Semi Sleeper");

	private final String label;
	
	public BusCategoryDto getDto() {
		BusCategoryDto busCategoryDto = new BusCategoryDto();
		busCategoryDto.setCode(this.name());
		busCategoryDto.setLabel(this.label);
		
		return busCategoryDto;
	}
}
