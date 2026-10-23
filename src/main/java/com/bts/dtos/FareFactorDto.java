package com.bts.dtos;

import com.bts.models.FareFactor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FareFactorDto {

	private String code;
	private String label;
	
	public static FareFactorDto getDto(FareFactor fareFactor) {
		FareFactorDto fareFactorDto = new FareFactorDto();
		
		fareFactorDto.setCode(fareFactor.name());
		fareFactorDto.setLabel(fareFactor.getLabel());
		
		return fareFactorDto;
	}
}
