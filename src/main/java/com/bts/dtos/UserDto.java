package com.bts.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private  String name;

	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")
	private String email;

	@Pattern(regexp="^((\\+91[-.\\s]?)?\\d{10}|0\\d{3}[-.\\s]?\\d{7})$")
	private String phone;

	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@Pattern(regexp = "^[a-zA-Z0-9!@#$()_]{8,}$")
	private String password;
	
	private String gender;
}
