package com.bts.models;

import com.bts.dtos.DeckTypeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum DeckType {

	UPPER_DECK("Upper Deck"),
	LOWER_DECK("Lower Deck");
	
	private final String label;
	
	public DeckTypeDto getDto() {
		DeckTypeDto deckTypeDto = new DeckTypeDto();
		deckTypeDto.setCode(this.name());
		deckTypeDto.setLabel(this.label);
		
		return deckTypeDto;
	}
}
