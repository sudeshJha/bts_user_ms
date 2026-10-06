package com.bts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.models.State;

public interface StateRepo extends JpaRepository<State, Long> {

}
