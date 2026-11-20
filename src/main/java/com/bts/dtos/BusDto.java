package com.bts.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bts.models.Bus;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusDto {
	
	private String vin;
	private String rtoNumber;
	private String manufacturer;
	private Boolean isActive;
	private BusLayoutDto busLayout;
	private List<String> busImages;
	private List<FareFactorDto> busFeatures;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<MultipartFile> images;
	
	public Bus getEntity() {
		Bus bus = new Bus();
		
		bus.setVin(this.vin);
		bus.setRtoNumber(this.rtoNumber);
		bus.setManufacturer(this.manufacturer);
		bus.setIsActive(this.isActive);
		bus.setBusLayout(this.busLayout.getEntity());
		
		return bus;
	}
	
}
