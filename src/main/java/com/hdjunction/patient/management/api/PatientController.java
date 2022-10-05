package com.hdjunction.patient.management.api;

import com.hdjunction.patient.management.api.util.ResourceLocationBuilder;
import com.hdjunction.patient.management.service.PatientService;
import com.hdjunction.patient.management.service.dto.FindingPatientResponse;
import com.hdjunction.patient.management.service.dto.RegisteringPatientFormRequest;
import com.hdjunction.patient.management.service.dto.UpdatingPatientFormRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * 환자정보와 환자의 모든 내원정보를 조회한다
     */
    @GetMapping("/api/patients/{id}")
    public FindingPatientResponse findPatient(@PathVariable Long id) {
        return patientService.findPatient(id);
    }

    /**
     * 환자정보를 등록한다
     */
    @PostMapping("/api/patients")
    public ResponseEntity<Void> registerPatient(@RequestBody RegisteringPatientFormRequest request) {
        Long id = patientService.registerPatient(request);
        return ResponseEntity.created(ResourceLocationBuilder.build(id)).build();
    }

    /**
     * 환자정보를 수정한다
     */
    @PatchMapping("/api/patients/{id}")
    public ResponseEntity<Void> updatePatient(@PathVariable Long id, @RequestBody UpdatingPatientFormRequest request) {
        patientService.update(id, request);
        return ResponseEntity.ok().build();
    }

    /**
     * 환자정보를 삭제한다
     */
    @DeleteMapping("/api/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
