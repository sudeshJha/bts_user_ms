package com.bts.auth.dtos;

import jakarta.validation.constraints.Pattern;

public class UserDto {
	private  String name;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")
	private String email;
	
	@Pattern(regexp="^((\\+91[-.\\s]?)?\\d{10}|0\\d{3}[-.\\s]?\\d{7})$")
	private String phone;
	
	@Pattern(regexp = "^[a-zA-Z0-9!@#$()_]{8,}$")
	private String password;
	
	public UserDto() {
		super();
	}
	
	public UserDto(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
