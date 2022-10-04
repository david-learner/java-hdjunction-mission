package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Hospital;
import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.repository.HospitalRepository;
import com.hdjunction.patient.management.repository.PatientRepository;
import com.hdjunction.patient.management.service.dto.RegisteringPatientFormRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class PatientCommandService {

    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;

    public PatientCommandService(HospitalRepository hospitalRepository, PatientRepository patientRepository) {
        this.hospitalRepository = hospitalRepository;
        this.patientRepository = patientRepository;
    }

    /**
     * 환자를 등록한다
     */
    public Long registerPatient(RegisteringPatientFormRequest request) {
        Hospital hospital = hospitalRepository.findById(request.getHospitalId()).orElseThrow(() -> {
            throw new NoSuchElementException("존재하지 않는 병원입니다.");
        });
        Patient newPatient = patientRepository.save(request.toPatient(hospital));
        return newPatient.getId();
    }
}
