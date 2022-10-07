package com.hdjunction.patient.management.api;

import com.hdjunction.patient.management.api.dto.FindingPatientResponse;
import com.hdjunction.patient.management.api.util.ResourceLocationBuilder;
import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.domain.Visit;
import com.hdjunction.patient.management.repository.dto.CustomPatientDto;
import com.hdjunction.patient.management.repository.dto.PatientSearchCondition;
import com.hdjunction.patient.management.service.PatientCommandService;
import com.hdjunction.patient.management.service.PatientQueryService;
import com.hdjunction.patient.management.service.VisitQueryService;
import com.hdjunction.patient.management.service.dto.RegisteringPatientFormRequest;
import com.hdjunction.patient.management.service.dto.UpdatingPatientFormRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private PatientCommandService patientCommandService;
    private PatientQueryService patientQueryService;
    private VisitQueryService visitQueryService;

    public PatientController(PatientCommandService patientCommandService, PatientQueryService patientQueryService, VisitQueryService visitQueryService) {
        this.patientCommandService = patientCommandService;
        this.patientQueryService = patientQueryService;
        this.visitQueryService = visitQueryService;
    }

    /**
     * 환자정보와 환자의 모든 내원정보를 조회한다
     */
    @GetMapping("/api/patients/{id}")
    public FindingPatientResponse findPatient(@PathVariable Long id) {
        Patient patient = patientQueryService.findPatient(id);
        List<Visit> visits = visitQueryService.findAllByPatientId(id);
        return new FindingPatientResponse(patient, visits);
    }

    /**
     * 전체 환자정보를 조회한다.
     * 환자정보는 이름, 환자등록번호, 성별, 생년월일, 휴대전화, 최근방문일을 포함한다.
     */
    @GetMapping("/api/patients")
    public List<CustomPatientDto> findAllPatients(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String registrationNumber,
            @RequestParam(required = false) String dateOfBirth
    ) {
        PatientSearchCondition condition = new PatientSearchCondition(name, registrationNumber, dateOfBirth);
        return patientQueryService.search(condition);
    }

    /**
     * 환자정보를 등록한다
     */
    @PostMapping("/api/patients")
    public ResponseEntity<Void> registerPatient(@RequestBody RegisteringPatientFormRequest request) {
        Long id = patientCommandService.registerPatient(request);
        return ResponseEntity.created(ResourceLocationBuilder.build(id)).build();
    }

    /**
     * 환자정보를 수정한다
     */
    @PatchMapping("/api/patients/{id}")
    public ResponseEntity<Void> updatePatient(@PathVariable Long id, @RequestBody UpdatingPatientFormRequest request) {
        patientCommandService.updatePatient(id, request);
        return ResponseEntity.ok().build();
    }

    /**
     * 환자정보를 삭제한다
     */
    @DeleteMapping("/api/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientCommandService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}
