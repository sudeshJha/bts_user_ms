package com.bts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.models.City;

public interface CityRepo extends JpaRepository<City, Long>{

}
