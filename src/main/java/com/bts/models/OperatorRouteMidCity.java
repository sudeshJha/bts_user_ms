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
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorRouteMidCity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long operatorRouteMidCityId;
	
	@ManyToOne
	@JoinColumn(name="operator_route_id")
	private OperatorRoute operatorRoute;
	
	@ManyToOne
	@JoinColumn(name="route_mid_city_id")
	private RouteMidCity routeMidCity;

}
