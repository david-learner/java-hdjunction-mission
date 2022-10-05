package com.hdjunction.patient.management.repository;

import com.hdjunction.patient.management.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
