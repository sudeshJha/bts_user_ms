package com.bts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.models.Route;

public interface RouteRepo extends JpaRepository<Route, Long> {

	List<Route> findBySourceCityAndDestinationCity(String sourceCity, String destinationCity);
}
