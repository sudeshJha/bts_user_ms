package com.bts.dtos;

import com.bts.models.OperatorVerificationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorDto {
	
	private UserDto userInfo;
	private String address;
	private Float seaterBasePrice;
	private Float sleeperBasePrice;
	private String licenseUrl;
	private String bannerUrl;
	private OperatorVerificationStatus verificationStatus;
}

