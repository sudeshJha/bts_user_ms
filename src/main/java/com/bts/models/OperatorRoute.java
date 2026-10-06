package com.bts.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="operator_routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorRoute {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer operatorRouteId;
	
	@ManyToOne
	@JoinColumn(name="operator_id")
	private Operator operator;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;

	@OneToMany(mappedBy="operatorRoute")
	private List<OperatorRouteMidCity> operatorRouteMidCities;
	
	
	
	
}
