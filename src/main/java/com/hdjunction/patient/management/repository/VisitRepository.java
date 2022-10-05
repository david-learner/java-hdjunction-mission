package com.hdjunction.patient.management.repository;

import com.hdjunction.patient.management.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findAllByPatientId(Long id);
}
