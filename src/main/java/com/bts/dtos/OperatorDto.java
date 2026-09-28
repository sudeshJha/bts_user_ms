package com.bts.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OperatorDto {

	private UserDto userInfo;
	private String address;
	private Float seaterBasePrice;
	private Float sleeperBasePrice;
	private String licenseUrl;
	private String bannerUrl;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private MultipartFile license;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private MultipartFile banner;

}

