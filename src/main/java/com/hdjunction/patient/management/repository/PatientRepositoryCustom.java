package com.hdjunction.patient.management.repository;

import com.hdjunction.patient.management.repository.dto.CustomPatientDto;
import com.hdjunction.patient.management.repository.dto.PatientSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientRepositoryCustom {

    Page<CustomPatientDto> search(PatientSearchCondition condition, Pageable pageable);
}
