package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.repository.PatientRepository;
import com.hdjunction.patient.management.repository.dto.CustomPatientFlatDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
public class PatientQueryService {

    private final PatientRepository patientRepository;

    public PatientQueryService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * 하나의 환자정보를 조회한다
     */
    public Patient findPatient(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 환자정보입니다."));
    }

    /**
     * 전체 환자정보를 조회한다
     */
    public List<CustomPatientFlatDto> findAllPatientsWithRecentReceiptDateTime() {
        return patientRepository.findAllPatientsWithRecentReceiptDateTime();
    }
}
