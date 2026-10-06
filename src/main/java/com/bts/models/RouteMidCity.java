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
@Table(name="route_mid_cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteMidCity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long routeMidCityId;
	
	@Column(nullable=false)
	private Integer stopSequence;
	
	@Column(nullable=false)
	private Integer distanceFromSource;
	
	@Column(nullable=false)
	private Integer timeFromSource;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
}


