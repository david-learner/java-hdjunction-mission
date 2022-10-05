package com.hdjunction.patient.management.service.dto;

public class RegisteringVisitRequest {

    private Long patientId;
    // todo default code
    private String statusCode = "1";

    private RegisteringVisitRequest() {
    }

    public RegisteringVisitRequest(Long patientId, String statusCode) {
        this.patientId = patientId;
        this.statusCode = statusCode;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
