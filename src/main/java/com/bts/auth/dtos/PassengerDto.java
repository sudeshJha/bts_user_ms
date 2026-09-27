package com.bts.auth.dtos;


public class PassengerDto {
	
	private Long passengerId;
	
	private  UserDto userInfo;

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public UserDto getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserDto userInfo) {
		this.userInfo = userInfo;
	}
}
