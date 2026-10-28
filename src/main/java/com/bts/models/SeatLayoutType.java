package com.bts.models;

import com.bts.dtos.SeatLayoutTypeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SeatLayoutType {

	TWO_BY_TWO_SEATER("2x2 Seater"),
	TWO_BY_THREE_SEATER("2x3 Seater"),
	TWO_BY_ONE_SEATER("2x1 Seater"),
	THREE_BY_THREE_SEATER("3x3 Seater"),
	TWO_BY_ONE_SLEEPER("2x1 Sleeper"),
	ONE_BY_ONE_SLEEPER("1x1 Sleeper");
	
	private final String label;
	
	public SeatLayoutTypeDto getDto() {
		SeatLayoutTypeDto seatLayoutTypeDto = new SeatLayoutTypeDto();
		seatLayoutTypeDto.setCode(this.name());
		seatLayoutTypeDto.setLabel(this.label);
		
		return seatLayoutTypeDto;
	}
}
