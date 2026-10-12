package com.bts.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bts.models.Route;

public interface RouteRepo extends JpaRepository<Route, Long> {

	 @Query("""
		        SELECT r FROM Route r
		        WHERE EXISTS (
		            SELECT 1 FROM RouteCity s, RouteCity d
		            WHERE s.route = r
		              AND d.route = r
		              AND LOWER(s.city.name) = LOWER(:source)
		              AND LOWER(d.city.name) = LOWER(:destination)
		              AND s.stopSequence < d.stopSequence
		        )
		        """)
	 List<Route> findRoutesByCities(@Param("source") String sourceCity, @Param("destination") String destinationCity);
}
