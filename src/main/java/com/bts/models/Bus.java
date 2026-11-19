package com.bts.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@Column(nullable=false)
	private String rtoNumber;
	
	@Column(nullable=false)
	private String manufacturer;
	
	@Column(nullable=false, length = 17)
	private String VIN;
	
	@Column(nullable=false)
	private Boolean isActive;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy="bus")
	private List<BusImage> busImages;
	
	@OneToMany(mappedBy="bus")
	private List<BusFeature> busFeatures;
	
	@OneToOne
	@JoinColumn(name="bus_layout_id")
	private BusLayout busLayout;
	
	@ManyToOne
	@JoinColumn(name="operator_id")
	private Operator operator;
}

