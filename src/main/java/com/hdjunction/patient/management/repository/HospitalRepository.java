package com.hdjunction.patient.management.repository;

import com.hdjunction.patient.management.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
