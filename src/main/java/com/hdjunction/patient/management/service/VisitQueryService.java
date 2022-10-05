package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Visit;
import com.hdjunction.patient.management.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VisitQueryService {

    private VisitRepository visitRepository;

    public VisitQueryService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> findAllByPatientId(Long id) {
        return visitRepository.findAllByPatientId(id);
    }
}
