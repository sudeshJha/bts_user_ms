package com.bts.dtos;

import com.bts.models.Status;
import com.bts.models.UserType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private String name;
	private String email;
	private String phone;
	private String gender;
	private UserType userType;
	private Status status;
	private String pic;
	private Boolean phoneVerified;
	private String verificationCode;
}
