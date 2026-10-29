package com.bts.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bus_layouts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusLayout {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer busLayoutId;
	
	private Integer backRowSeats;
	private Integer lowerDeckerSleeperRows;
	private Integer lowerDeckerSeaterRows;
	private Integer upperDeckerRows;
	
	@ManyToOne
	@JoinColumn(name="seat_layout_id")
	private SeatLayout seatLayout;
}
