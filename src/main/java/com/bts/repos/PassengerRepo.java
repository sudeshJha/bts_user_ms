package com.bts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.models.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, Long> {

}
