package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.repository.HospitalRepository;
import com.hdjunction.patient.management.service.dto.RegisteringHospitalFormRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HospitalCommandService {

    private final HospitalRepository hospitalRepository;

    public HospitalCommandService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    /**
     * 병원정보를 등록한다
     */
    public Long registerHospital(RegisteringHospitalFormRequest request) {
        return hospitalRepository.save(request.toHospital()).getId();
    }
}
