package com.bts.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusLayoutDto {
	
	private Integer seaterRows;
	private Integer backRowSeats;	
	private Integer sleeperRows;
	private DeckTypeDto deckType;
	private SeatLayoutTypeDto seatLayoutType;
	private BusCategoryDto busCategory;

}
