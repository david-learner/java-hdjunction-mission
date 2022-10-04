package com.hdjunction.patient.management.repository;

import com.hdjunction.patient.management.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}
