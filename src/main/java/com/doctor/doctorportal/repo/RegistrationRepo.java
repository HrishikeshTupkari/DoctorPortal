package com.doctor.doctorportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.doctorportal.entity.Appointments;
import com.doctor.doctorportal.entity.Registration;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Integer>{

}
