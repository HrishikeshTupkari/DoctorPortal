package com.doctor.doctorportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "Appointments")
public class Appointments {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sequenceId", updatable = false, nullable = false)
	private Integer sequenceId;
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
	public Integer getSequenceId() {
		return sequenceId;
	}
	public void setSequenceId(Integer sequenceId) {
		sequenceId = sequenceId;
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
	@Override
	public String toString() {
		return "Appointments [sequenceId=" + sequenceId + ", Name=" + Name + ", Email=" + Email + ", Cell=" + Cell + "]";
	}



}
