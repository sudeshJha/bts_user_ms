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
@Table(name="bus_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusImage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer busImageId;
	
	@Column(nullable = false)
	private String path;
	
	@ManyToOne
	@JoinColumn(name="bus_id")
	private Bus bus;
}
