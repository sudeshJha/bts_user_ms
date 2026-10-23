package com.bts.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BusLayout {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer busLayoutId;
	private Integer backRowSeats;
	private Integer lowerDeckerSleeperRows;
	private Integer lowerDeckerSeaterRows;
	private Integer upperDeckerRows;
}
