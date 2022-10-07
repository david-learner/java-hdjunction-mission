package com.hdjunction.patient.management.repository;

import com.hdjunction.patient.management.repository.dto.CustomPatientDto;
import com.hdjunction.patient.management.repository.dto.PatientSearchCondition;

import java.util.List;

public interface PatientRepositoryCustom {

    List<CustomPatientDto> search(PatientSearchCondition condition);
}
