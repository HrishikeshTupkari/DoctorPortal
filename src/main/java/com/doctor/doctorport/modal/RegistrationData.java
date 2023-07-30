package com.doctor.doctorport.modal;

public class RegistrationData {
	private String name;
	private String cell;
	private String email;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RegistrationData(String name, String cell, String email, String password) {
		super();
		this.name = name;
		this.cell = cell;
		this.email = email;
		this.password = password;
	}
	public RegistrationData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
