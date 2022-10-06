package com.hdjunction.patient.management.service.dto;

import com.hdjunction.patient.management.domain.Visit;

public class VisitRequest {

    private Long patientId;
    // todo default code
    private String statusCode = "1";

    private VisitRequest() {
    }

    public VisitRequest(Long patientId, String statusCode) {
        this.patientId = patientId;
        this.statusCode = statusCode;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public Visit toVisit() {
        return new Visit(this.statusCode);
    }
}
