package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Hospital;
import com.hdjunction.patient.management.repository.HospitalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
public class HospitalQueryService {

    private final HospitalRepository hospitalRepository;

    public HospitalQueryService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    /**
     *  하나의 병원정보를 조회한다
     */
    public Hospital findHospital(Long id) {
        return hospitalRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 병원입니다."));
    }
}
