package com.doctor.doctorportal.dto;

import org.springframework.stereotype.Component;

public class PatientDTO {

	private String name;
	private String email;
	private int cell;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
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
	public int getCell() {
		return cell;
	}
	public void setCell(int cell) {
		this.cell = cell;
	}
	@Override
	public String toString() {
		return "PatientDTO [name=" + name + ", email=" + email + ", cell=" + cell + "]";
	}
	
}
