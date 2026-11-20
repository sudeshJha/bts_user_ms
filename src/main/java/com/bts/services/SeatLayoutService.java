package com.bts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.models.DeckType;
import com.bts.models.SeatLayout;
import com.bts.models.SeatLayoutType;
import com.bts.repos.SeatLayoutRepo;

@Service
public class SeatLayoutService {

	@Autowired
	private SeatLayoutRepo seatLayoutRepo;
	
	public SeatLayout getSeatLayoutBySeatLayoutTypeAndDeckType(SeatLayoutType seatLayoutType, DeckType deckType) {
		
		List<SeatLayout> seatLayouts = seatLayoutRepo.findByDeckTypeAndSeatLayoutType(deckType, seatLayoutType);
		
		if(seatLayouts.size() == 0) {
			return null;
		}
		
		return seatLayouts.get(0);
	}
}
