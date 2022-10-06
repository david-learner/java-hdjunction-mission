package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Visit;
import com.hdjunction.patient.management.repository.VisitRepository;
import com.hdjunction.patient.management.service.dto.VisitResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class VisitQueryService {

    private VisitRepository visitRepository;

    public VisitQueryService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     *  하나의 내원내역을 조회한다
     */
    public VisitResponse findById(Long id) {
        Visit visit = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("내원정보가 존재하지 않습니다."));
        return new VisitResponse(visit);
    }

    /**
     *  여러 개의 내원내역을 조회한다
     */
    public List<Visit> findAllByPatientId(Long id) {
        return visitRepository.findAllByPatientId(id);
    }
}
