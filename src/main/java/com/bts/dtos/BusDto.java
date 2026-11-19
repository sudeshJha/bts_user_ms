package com.bts.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	private List<MultipartFile> busImages;
	private List<BusLayoutDto> busLayout;
	private List<FareFactorDto> busFeatures;
	
}
