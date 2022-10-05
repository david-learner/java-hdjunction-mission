package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Hospital;
import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.repository.HospitalRepository;
import com.hdjunction.patient.management.repository.PatientRepository;
import com.hdjunction.patient.management.service.dto.FindingPatientResponse;
import com.hdjunction.patient.management.service.dto.RegisteringPatientFormRequest;
import com.hdjunction.patient.management.service.dto.UpdatingPatientFormRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Transactional
public class PatientService {

    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;

    public PatientService(HospitalRepository hospitalRepository, PatientRepository patientRepository) {
        this.hospitalRepository = hospitalRepository;
        this.patientRepository = patientRepository;
    }

    /**
     * 환자정보와 환자의 모든 내원정보를 조회한다
     */
    @Transactional(readOnly = true)
    public FindingPatientResponse findPatient(Long id) {
        Patient patient = findPatientById(id);
        return new FindingPatientResponse(patient, null);
    }

    /**
     * 환자정보를 등록한다
     */
    public Long registerPatient(RegisteringPatientFormRequest request) {
        Hospital hospital = findHospitalById(request.getHospitalId());
        Patient newPatient = patientRepository.save(request.toPatient(hospital));
        return newPatient.getId();
    }

    /**
     * 환자정보를 수정한다
     */
    public void update(Long id, UpdatingPatientFormRequest request) {
        Long hospitalId = request.getHospitalId();
        Hospital hospital = null;
        if (Objects.nonNull(hospitalId)) {
            hospital = findHospitalById(hospitalId);
        }

        Patient patient = findPatientById(id);
        patient.update(request.toPatient(hospital));
    }

    private Hospital findHospitalById(Long id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 병원입니다."));
        return hospital;
    }

    private Patient findPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 환자정보입니다."));
        return patient;
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
