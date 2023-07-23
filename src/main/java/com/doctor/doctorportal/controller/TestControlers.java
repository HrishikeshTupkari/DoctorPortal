package com.doctor.doctorportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.doctorportal.dto.PatientDTO;
import com.doctor.doctorportal.entity.Appointments;
import com.doctor.doctorportal.entity.Registration;
import com.doctor.doctorportal.repo.AppointmentsRepo;
import com.doctor.doctorportal.repo.RegistrationRepo;

@RestController
public class TestControlers {
	@Autowired
	RegistrationRepo patientRepo;
	
	@GetMapping("/test")
	public void setDetails()
	{
		Registration registration = new Registration();
		patientRepo.save(registration);
	}
	//hello
	@PostMapping("/test1")
	public void post(PatientDTO TestDTO)
	{
		Registration registration = new Registration();
		patientRepo.save(registration);
	}

}
