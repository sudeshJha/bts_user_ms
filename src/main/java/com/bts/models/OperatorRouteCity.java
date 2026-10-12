package com.bts.models;


import jakarta.persistence.Column;
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
@Table(name="operator_route_cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorRouteCity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long operatorRouteCityId;
	
	@Column(nullable=false)
	private Integer haltTime;
	
	@ManyToOne
	@JoinColumn(name="operator_route_id")
	private OperatorRoute operatorRoute;
	
	@ManyToOne
	@JoinColumn(name="route_mid_city_id")
	private RouteCity routeCity;
}
