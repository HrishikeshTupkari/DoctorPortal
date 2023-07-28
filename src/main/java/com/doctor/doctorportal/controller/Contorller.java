package com.doctor.doctorportal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.doctorportal.dto.PatientDTO;
import com.doctor.doctorportal.entity.Appointments;
import com.doctor.doctorportal.entity.Keys;
import com.doctor.doctorportal.entity.Registration;
import com.doctor.doctorportal.repo.KeysRepo;
import com.doctor.doctorportal.repo.RegistrationRepo;
import com.doctor.doctorportal.service.AppointmentsService;
import com.doctor.doctorportal.service.RegistrationService;

@RestController
public class Contorller {
	

	@Autowired
	AppointmentsService appointmentsService;
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	RegistrationRepo registrationRepo;
	
	@Autowired
	KeysRepo keysRepo;
	

	@GetMapping("/login/{email}/{password}")
	public PatientDTO login(@PathVariable(value="email") String email,@PathVariable(value="password") String password)
	{
		PatientDTO patientDTO = null;
		Keys  key=keysRepo.findRegistrationId(email, password);
		try {
			Optional<Registration> RegisteredPatient=null;
			RegisteredPatient= 
			registrationRepo.findById(Integer.valueOf(String.valueOf(key.getRegistrationid())));
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(email + "= ID Not Registered!");
		}
		return patientDTO;
		
	}

	
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
