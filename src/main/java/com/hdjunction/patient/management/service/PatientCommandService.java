package com.hdjunction.patient.management.service;

import com.hdjunction.patient.management.domain.Hospital;
import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.repository.PatientRepository;
import com.hdjunction.patient.management.service.dto.RegisteringPatientFormRequest;
import com.hdjunction.patient.management.service.dto.UpdatingPatientFormRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class PatientCommandService {

    private final HospitalQueryService hospitalQueryService;
    private final PatientQueryService patientQueryService;
    private final PatientRepository patientRepository;

    public PatientCommandService(HospitalQueryService hospitalQueryService, PatientQueryService patientQueryService, PatientRepository patientRepository) {
        this.hospitalQueryService = hospitalQueryService;
        this.patientQueryService = patientQueryService;
        this.patientRepository = patientRepository;
    }

    /**
     * 환자정보를 등록한다
     */
    public Long registerPatient(RegisteringPatientFormRequest request) {
        Hospital hospital = hospitalQueryService.findHospital(request.getHospitalId());
        Patient newPatient = patientRepository.save(request.toPatient(hospital));
        return newPatient.getId();
    }

    /**
     * 환자정보를 수정한다
     */
    public void updatePatient(Long id, UpdatingPatientFormRequest request) {
        Long hospitalId = request.getHospitalId();
        Hospital hospital = null;
        if (Objects.nonNull(hospitalId)) {
            hospital = hospitalQueryService.findHospital(hospitalId);
        }

        Patient patient = patientQueryService.findPatient(id);
        patient.update(request.toPatient(hospital));
    }

    /**
     *  환자정보를 삭제한다
     */
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
