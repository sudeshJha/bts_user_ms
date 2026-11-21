package com.bts.services;

import org.springframework.stereotype.Service;

import com.bts.models.DeckType;
import com.bts.models.SeatLayout;
import com.bts.models.SeatLayoutType;

@Service
public class BusLayoutService {
	
	public void saveBusLayout() {
		SeatLayoutType seatLayoutType = SeatLayoutType.valueOf(busDto.getBusLayout().getSeatLayoutType().getCode());
		DeckType deckType = DeckType.valueOf(busDto.getBusLayout().getDeckType().getCode());
		
		
		SeatLayout seatLayout = seatLayoutService.getSeatLayoutBySeatLayoutTypeAndDeckType(seatLayoutType, deckType);
	}

}
