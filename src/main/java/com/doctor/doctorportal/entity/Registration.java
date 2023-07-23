package com.doctor.doctorportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Registration")
public class Registration {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "registrationid", updatable = false, nullable = false)
	private Long registrationid;
	private String Name;
	private String Email;
	private int Cell;

	public Long getRegistrationid() {
		return registrationid;
	}

	public void setRegistrationid(Long registrationid) {
		this.registrationid = registrationid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getCell() {
		return Cell;
	}

	public void setCell(int cell) {
		Cell = cell;
	}

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}


	}


