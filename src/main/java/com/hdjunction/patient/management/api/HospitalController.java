package com.hdjunction.patient.management.api;

import com.hdjunction.patient.management.api.dto.RegisteringHospitalFormRequest;
import com.hdjunction.patient.management.api.util.ResourceLocationBuilder;
import com.hdjunction.patient.management.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

    private HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    /**
     * 병원정보를 등록한다
     */
    @PostMapping("/api/hospitals")
    public ResponseEntity<Void> registerHospital(@RequestBody RegisteringHospitalFormRequest request) {
        Long id = hospitalRepository.save(request.toHospital()).getId();
        return ResponseEntity.created(ResourceLocationBuilder.build(id)).build();
    }
}
