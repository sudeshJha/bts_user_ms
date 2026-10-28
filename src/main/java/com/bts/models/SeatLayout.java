package com.bts.models;

import java.util.List;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class SeatLayout {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer seatLayoutId;
	
	@Enumerated(EnumType.STRING)
	private SeatLayoutType seatLayoutType;
	
	@Enumerated(EnumType.STRING)
	private DeckType deckType;
	
	@Enumerated(EnumType.STRING)
	private BusCategory busCategory;
	
	@OneToMany(mappedBy="seatLayout")
	private List<BusLayout> busLayouts;
}
