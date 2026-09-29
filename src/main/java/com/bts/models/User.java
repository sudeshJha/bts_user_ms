package com.bts.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false, unique = true)
	private String email;

	@Column(nullable=false, unique=true)
	private String phone;

	@Column(nullable=false)
	private String password;

	private String gender;

	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private UserType userType;

	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Status status = Status.INACTIVE;

	@Column(nullable=false)
	private Boolean emailVerified = false;

	private String pic;

	private Boolean phoneVerfified;

	private String verificationCode;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private Timestamp updatedAt;

}
