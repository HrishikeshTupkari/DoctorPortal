package com.doctor.doctorportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "Keys")
public class Keys {
	
	@Id
	private Long registrationid;
	@Column(unique = true)
	private String email;
	private String password;
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

	public Long getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(Long registrationid) {
		this.registrationid = registrationid;
	}
	public Keys() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
