package com.bts.models;

import java.util.ArrayList;
import java.util.List;

import com.bts.dtos.OperatorRouteCityDto;
import com.bts.dtos.OperatorRouteDto;

import jakarta.persistence.CascadeType;
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
@Table(name="operator_routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorRoute {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long operatorRouteId;
	
	@ManyToOne
	@JoinColumn(name="operator_id")
	private Operator operator;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
	
	@Column(nullable=false)
	private Boolean isActive = false;

	@OneToMany(mappedBy="operatorRoute", cascade = CascadeType.ALL)
	private List<OperatorRouteCity> operatorRouteCities;
	
	public OperatorRouteDto getDto() {
		OperatorRouteDto operatorRouteDto = new OperatorRouteDto();
		
		List<OperatorRouteCityDto> operatorRouteCitiesDto = new ArrayList<>();
		
		for(OperatorRouteCity operatorRouteCity : this.operatorRouteCities) {
			System.out.println(operatorRouteCity.getOperatorRouteCityId());
			operatorRouteCitiesDto.add(operatorRouteCity.getDto());
		}
		
		
		operatorRouteDto.setOperatorRouteId(this.operatorRouteId);
		operatorRouteDto.setIsActive(this.isActive);
		operatorRouteDto.setRoute(this.route.getDto());
		operatorRouteDto.setOperatorRouteCities(operatorRouteCitiesDto);
		
		return operatorRouteDto;
		
	}
}
