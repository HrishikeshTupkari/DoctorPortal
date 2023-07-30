package com.doctor.doctorportal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.doctorport.modal.FormData;
import com.doctor.doctorport.modal.LoginData;
import com.doctor.doctorportal.dto.LoginResponseDTO;
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
	

    
    @GetMapping("patient")
    public LoginResponseDTO getPatient(@ModelAttribute("formData") LoginData loginData)
    {
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
    	System.out.println(loginData);
		PatientDTO patientDTO = new PatientDTO();;
		Keys  key=keysRepo.findRegistrationId(loginData.getEmail(), loginData.getPassword());
		if (null!=key)
		{
			Registration RegisteredPatient=null;
			RegisteredPatient= 
			registrationRepo.findbyRegistrationId(key.getRegistrationid());
			patientDTO.setName(RegisteredPatient.getName());
			patientDTO.setCell(RegisteredPatient.getCell());
			patientDTO.setEmail(RegisteredPatient.getEmail());
			loginResponseDTO.setMessage("User Found!");
			loginResponseDTO.setPatientDTO(patientDTO);
		}
		else
		{
			loginResponseDTO.setMessage("Invalid Username or password");
			loginResponseDTO.setPatientDTO(null);
		}
		return loginResponseDTO;
    }

	@GetMapping("/login/{email}/{password}")
	@ResponseBody
	public LoginResponseDTO login(@PathVariable(value="email") String email,@PathVariable(value="password") String password)
	{
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		PatientDTO patientDTO = new PatientDTO();
		Keys  key=keysRepo.findRegistrationId(email, password);
		if (null!=key)
		{
			Registration RegisteredPatient=null;
			RegisteredPatient= 
			registrationRepo.findbyRegistrationId(key.getRegistrationid());
			patientDTO.setName(RegisteredPatient.getName());
			patientDTO.setCell(RegisteredPatient.getCell());
			patientDTO.setEmail(RegisteredPatient.getEmail());
			loginResponseDTO.setMessage("User Found!");
			loginResponseDTO.setPatientDTO(patientDTO);
		}
		else
		{
			loginResponseDTO.setMessage("Invalid Username or password");
			loginResponseDTO.setPatientDTO(null);
		}
		return loginResponseDTO;
		
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
