package com.bts.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="operator_fare_factors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorFareFactor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long operatorFareFactorId;
	
	private Float price;
	
	@Enumerated(EnumType.STRING)
	private FareFactor fareFactor;
	
	@ManyToOne
	@JoinColumn(name="operator_id")
	private Operator operator;

}
