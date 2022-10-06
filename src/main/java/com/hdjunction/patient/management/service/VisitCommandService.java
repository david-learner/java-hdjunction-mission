package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.domain.Visit;
import com.hdjunction.patient.management.repository.VisitRepository;
import com.hdjunction.patient.management.service.dto.VisitRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
    public Long registerVisit(VisitRequest request) {
        Patient patient = patientQueryService.findPatient(request.getPatientId());
        Visit visit = new Visit(patient.getHospital(), patient, LocalDateTime.now(), request.getStatusCode());
        return visitRepository.save(visit).getId();
    }

    /**
     * 내원정보를 수정한다
     */
    public void updateVisit(Long id, VisitRequest request) {
        Visit visit = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("내원정보가 존재하지 않습니다."));
        visit.update(request.toVisit());
    }
}
