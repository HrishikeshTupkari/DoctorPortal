package com.doctor.doctorportal.dto;

public class LoginResponseDTO {
	private String message;
	private PatientDTO  patientDTO;
	public LoginResponseDTO(String message, PatientDTO patientDTO) {
		super();
		this.message = message;
		this.patientDTO = patientDTO;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PatientDTO getPatientDTO() {
		return patientDTO;
	}
	public void setPatientDTO(PatientDTO patientDTO) {
		this.patientDTO = patientDTO;
	}
	public LoginResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
