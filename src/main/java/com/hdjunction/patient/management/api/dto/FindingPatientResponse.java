package com.hdjunction.patient.management.api.dto;

import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.domain.Visit;

import java.util.List;

public class FindingPatientResponse {

    private PatientFlatDto patient;
    private List<VisitFlatDto> visits;

    public FindingPatientResponse(Patient patient, List<Visit> visits) {
        this.patient = new PatientFlatDto(patient);
        this.visits = visits.stream().map(VisitFlatDto::new).toList();
    }

    public PatientFlatDto getPatient() {
        return patient;
    }

    public List<VisitFlatDto> getVisits() {
        return visits;
    }
}
