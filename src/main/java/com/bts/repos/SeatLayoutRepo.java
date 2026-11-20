package com.bts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.models.SeatLayout;
import java.util.List;
import com.bts.models.DeckType;
import com.bts.models.SeatLayoutType;


public interface SeatLayoutRepo extends JpaRepository<SeatLayout, Long> {

	public List<SeatLayout> findByDeckTypeAndSeatLayoutType(DeckType deckType, SeatLayoutType seatLayoutType);
}
