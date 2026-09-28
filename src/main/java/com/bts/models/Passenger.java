package com.bts.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="passengers")
@Getter
@Setter
@NoArgsConstructor
public class Passenger{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long passengerId;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
}
