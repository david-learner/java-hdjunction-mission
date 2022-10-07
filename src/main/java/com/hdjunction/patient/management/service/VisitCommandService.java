package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.domain.RecentReceiptDateTime;
import com.hdjunction.patient.management.domain.Visit;
import com.hdjunction.patient.management.repository.RecentReceiptDateTimeRepository;
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
    private final RecentReceiptDateTimeRepository recentReceiptDateTimeRepository;

    public VisitCommandService(PatientQueryService patientQueryService,
                               VisitRepository visitRepository,
                               RecentReceiptDateTimeRepository recentReceiptDateTimeRepository) {
        this.patientQueryService = patientQueryService;
        this.visitRepository = visitRepository;
        this.recentReceiptDateTimeRepository = recentReceiptDateTimeRepository;
    }

    /**
     * 내원정보를 등록한다
     */
    public Long registerVisit(VisitRequest request) {
        Patient patient = patientQueryService.findPatient(request.getPatientId());
        LocalDateTime receiptDateTime = LocalDateTime.now();
        Visit visit = new Visit(patient.getHospital(), patient, receiptDateTime, request.getStatusCode());
        saveReceiptDateTime(patient, receiptDateTime);
        return visitRepository.save(visit).getId();
    }

    /**
     * 최근 내원일시를 저장(또는 업데이트)한다.
     */
    private void saveReceiptDateTime(Patient patient, LocalDateTime receiptDateTime) {
        recentReceiptDateTimeRepository.findById(patient.getId()).ifPresentOrElse(
                recentReceiptDateTime -> recentReceiptDateTime.updateReceiptDateTime(receiptDateTime),
                () -> recentReceiptDateTimeRepository.save(new RecentReceiptDateTime(patient, receiptDateTime))
        );
    }

    /**
     * 내원정보를 수정한다
     */
    public void updateVisit(Long id, VisitRequest request) {
        Visit visit = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("내원정보가 존재하지 않습니다."));
        visit.update(request.toVisit());
    }

    /**
     * 내원정보를 삭제한다
     */
    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }
}
