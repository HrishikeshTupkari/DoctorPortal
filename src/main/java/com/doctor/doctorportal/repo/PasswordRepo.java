package com.doctor.doctorportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.doctorportal.entity.Keys;

@Repository
public interface PasswordRepo extends JpaRepository<Keys,Long> {

}
