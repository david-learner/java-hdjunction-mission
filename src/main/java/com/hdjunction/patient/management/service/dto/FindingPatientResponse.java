package com.hdjunction.patient.management.service.dto;

import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.domain.Visit;

import java.util.List;

public class FindingPatientResponse {
    private Patient patient;
    private List<Visit> visits;

    public FindingPatientResponse(Patient patient, List<Visit> visits) {
        this.patient = patient;
        this.visits = visits;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<Visit> getVisits() {
        return visits;
    }
}
