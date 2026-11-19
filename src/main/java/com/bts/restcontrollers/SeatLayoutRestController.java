package com.bts.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.DeckTypeDto;
import com.bts.dtos.SeatLayoutTypeDto;
import com.bts.models.DeckType;
import com.bts.models.SeatLayoutType;

@RestController
public class SeatLayoutRestController {
	
	@GetMapping("/seat_layout_types")
	public ApiResponse<List<SeatLayoutTypeDto>> allSeatLayoutTypes(){
		
		List<SeatLayoutTypeDto> seatLayoutTypesDto = new ArrayList<>();
		
		for(SeatLayoutType seatLayoutType : SeatLayoutType.values()) {
			seatLayoutTypesDto.add(seatLayoutType.getDto());
		}
		
		return new ApiResponse<>("Successfully fetched seat layout types",seatLayoutTypesDto);
	}
	
	@GetMapping("/deck_types")
	public ApiResponse<List<DeckTypeDto>> allDeckTypes(){
		
		
		List<DeckTypeDto> deckTypesDto = new ArrayList<>();
		
		for(DeckType deckType : DeckType.values()) {
			deckTypesDto.add(deckType.getDto());
		}

		return new ApiResponse<>("Successfully fetched deck types",deckTypesDto);
	}
}
