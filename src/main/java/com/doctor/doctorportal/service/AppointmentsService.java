package com.doctor.doctorportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.doctorportal.dto.PatientDTO;
import com.doctor.doctorportal.entity.Appointments;
import com.doctor.doctorportal.entity.Registration;
import com.doctor.doctorportal.repo.AppointmentsRepo;
import com.doctor.doctorportal.repo.RegistrationRepo;

@Service
public class AppointmentsService {
	
	@Autowired
	AppointmentsRepo appointmentsRepo;
	
	@Autowired
	RegistrationRepo registrationRepo;

	public void saveAppointment(PatientDTO patientDTO) {
		Appointments appointments = new Appointments();
		appointments.setRegistrationid(-1L);
		appointments.setCell(patientDTO.getCell());
		appointments.setEmail(patientDTO.getEmail());
		appointments.setName(patientDTO.getName());
		appointmentsRepo.save(appointments);
		
		
		
	}


}
