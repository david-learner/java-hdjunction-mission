package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.repository.PatientRepository;
import com.hdjunction.patient.management.service.dto.FindingPatientResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
public class PatientQueryService {

    private final PatientRepository patientRepository;

    public PatientQueryService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * 환자정보를 조회한다
     */
    public Patient findPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 환자정보입니다."));
        return patient;
    }

    /**
     * 환자정보와 환자의 모든 내원정보를 조회한다
     */
    // todo assembler 패턴 적용
    public FindingPatientResponse findPatientAndVisit(Long id) {
        Patient patient = findPatient(id);
        return new FindingPatientResponse(patient, null);
    }
}
