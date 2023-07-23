package com.doctor.doctorportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.doctorportal.dto.PatientDTO;
import com.doctor.doctorportal.entity.Appointments;
import com.doctor.doctorportal.entity.Registration;
import com.doctor.doctorportal.repo.RegistrationRepo;
import com.doctor.doctorportal.service.AppointmentsService;
import com.doctor.doctorportal.service.RegistrationService;

@RestController
public class Contorller {
	

	@Autowired
	AppointmentsService appointmentsService;
	
	@Autowired
	RegistrationService registrationService;
	

	

	
	@PostMapping("/bookappointment")
	public ResponseEntity<String> bookAppointment(@RequestBody PatientDTO patientDTO)
	{
		appointmentsService.saveAppointment(patientDTO);
		return new ResponseEntity<>(patientDTO +"Appointment Booked !", HttpStatus.OK);

	}
	
	@PostMapping("/register/patient")
	public ResponseEntity<String> registerPatient(@RequestBody PatientDTO patientDTO)
	{
		registrationService.saveRegistration(patientDTO);
		return new ResponseEntity<>(patientDTO +"Resgitered !", HttpStatus.OK);

	}
	
	@GetMapping("/sayhello")
	public String sayHello()
	{
		return "Hello";
	}

}
