package com.bts.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="seat_layouts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SeatLayout {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seatLayoutId;
	
	@Enumerated(EnumType.STRING)
	private SeatLayoutType seatLayoutType;
	
	@Enumerated(EnumType.STRING)
	private DeckType deckType;
	
	@Enumerated(EnumType.STRING)
	private BusCategory busCategory;
	
	@OneToMany(mappedBy="seatLayout")
	private List<BusLayout> busLayouts;
}
