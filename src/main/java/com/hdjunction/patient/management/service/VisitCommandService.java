package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.domain.Visit;
import com.hdjunction.patient.management.repository.VisitRepository;
import com.hdjunction.patient.management.service.dto.RegisteringVisitRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class VisitCommandService {

    private final PatientQueryService patientQueryService;
    private final VisitRepository visitRepository;

    public VisitCommandService(PatientQueryService patientQueryService, VisitRepository visitRepository) {
        this.patientQueryService = patientQueryService;
        this.visitRepository = visitRepository;
    }

    /**
     * 내원정보를 등록한다
     */
    public Long registerVisit(RegisteringVisitRequest request) {
        Patient patient = patientQueryService.findPatient(request.getPatientId());
        Visit visit = new Visit(patient.getHospital(), patient, LocalDateTime.now(), request.getStatusCode());
        return visitRepository.save(visit).getId();
    }
}
