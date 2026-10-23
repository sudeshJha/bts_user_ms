package com.bts.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="buses")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer busId;
	private String rtoNumber;
	private String manufacturer;
	private Boolean isActive;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
