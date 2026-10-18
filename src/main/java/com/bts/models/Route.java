package com.bts.models;

import java.util.List;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long routeId;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(nullable=false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy="route")
	private List<OperatorRoute> operatorRoute;
	
	@OneToMany(mappedBy="route")
	private List<RouteCity> routeCities;
	
	public Route(Long routeId) {
		this.routeId = routeId;
	}
}
