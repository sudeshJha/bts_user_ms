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
@Table(name="bus_features")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusFeature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer busFeatureId;
	
	@ManyToOne
	@JoinColumn(name="operator_fare_factor_id")
	private OperatorFareFactor operatorFareFactor;
	
	@ManyToOne
	@JoinColumn(name="bus_id")
	private Bus bus;
}
