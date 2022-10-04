package com.hdjunction.patient.management.api;

import com.hdjunction.patient.management.api.util.ResourceLocationBuilder;
import com.hdjunction.patient.management.service.PatientCommandService;
import com.hdjunction.patient.management.service.dto.RegisteringPatientForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private PatientCommandService patientCommandService;

    public PatientController(PatientCommandService patientCommandService) {
        this.patientCommandService = patientCommandService;
    }

    /**
     * 환자정보를 등록한다
     */
    @PostMapping("/api/patients")
    public ResponseEntity<Void> registerPatient(RegisteringPatientFormRequest request) {
        Long id = patientCommandService.registerPatient(request);
        return ResponseEntity.created(ResourceLocationBuilder.build(id)).build();
    }
}
