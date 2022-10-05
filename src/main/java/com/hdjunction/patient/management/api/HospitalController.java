package com.hdjunction.patient.management.api;

import com.hdjunction.patient.management.api.util.ResourceLocationBuilder;
import com.hdjunction.patient.management.service.HospitalCommandService;
import com.hdjunction.patient.management.service.dto.RegisteringHospitalFormRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

    private final HospitalCommandService hospitalCommandService;

    public HospitalController(HospitalCommandService hospitalCommandService) {
        this.hospitalCommandService = hospitalCommandService;
    }

    /**
     * 병원정보를 등록한다
     */
    @PostMapping("/api/hospitals")
    public ResponseEntity<Void> registerHospital(@RequestBody RegisteringHospitalFormRequest request) {
        Long id = hospitalCommandService.registerHospital(request);
        return ResponseEntity.created(ResourceLocationBuilder.build(id)).build();
    }
}
