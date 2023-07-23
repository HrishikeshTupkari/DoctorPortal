package com.doctor.doctorportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.doctorportal.dto.PatientDTO;
import com.doctor.doctorportal.entity.Keys;
import com.doctor.doctorportal.entity.Registration;
import com.doctor.doctorportal.repo.PasswordRepo;
import com.doctor.doctorportal.repo.RegistrationRepo;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepo registrationRepo;
	
	@Autowired
	PasswordRepo passwordRepo;
	
	public void saveRegistration(PatientDTO patientDTO) {
		Registration registration = new Registration();
		Keys password= new Keys();
		registration.setCell(patientDTO.getCell());
		registration.setEmail(patientDTO.getEmail());
		registration.setName(patientDTO.getName());
		registrationRepo.save(registration);
		password.setEmail(patientDTO.getEmail());
		password.setRegistrationid(registration.getRegistrationid());
		password.setPassword(patientDTO.getPassword());
		passwordRepo.save(null);
		
	}

}
