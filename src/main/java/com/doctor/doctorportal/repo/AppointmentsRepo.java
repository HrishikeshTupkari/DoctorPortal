package com.doctor.doctorportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.doctor.doctorportal.entity.Appointments;

@Repository
public interface AppointmentsRepo extends JpaRepository<Appointments,Integer>{

}
