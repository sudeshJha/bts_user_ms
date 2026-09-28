package com.bts.dtos;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OperatorDto {

	private UserDto userInfo;
	private String gender;
	private String address;
	private Float seaterBasePrice;
	private Float sleeperBasePrice;
	private String licenseUrl;
	private String bannerUrl;
	private MultipartFile license;
	private MultipartFile banner;

}

