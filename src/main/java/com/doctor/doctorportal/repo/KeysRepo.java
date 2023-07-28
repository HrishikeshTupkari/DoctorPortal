package com.doctor.doctorportal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doctor.doctorportal.entity.Appointments;
import com.doctor.doctorportal.entity.Keys;

public interface KeysRepo  extends JpaRepository<Keys,Long>{
	@Query(nativeQuery = true, value = "SELECT * FROM Keys where email = :email and password = :password")
	Keys findRegistrationId(String email, String password);
}
