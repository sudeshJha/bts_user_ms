package com.bts.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="states")
@Getter
@Setter
@NoArgsConstructor
public class State {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long stateId;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy="state")
	private List<City> cities;
	

}
