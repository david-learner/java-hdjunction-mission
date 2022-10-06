package com.hdjunction.patient.management.api.dto;

import com.hdjunction.patient.management.domain.Visit;

import java.time.LocalDateTime;

public class VisitFlatDto {

    private Long hospitalId;
    private Long patientId;
    private Long visitId;
    private LocalDateTime receiptDateTime;
    private String statusCode;

    public VisitFlatDto(Visit visit) {
        this.hospitalId = visit.getHospital().getId();
        this.patientId = visit.getPatient().getId();
        this.visitId = visit.getId();
        this.receiptDateTime = visit.getReceiptDateTime();
        this.statusCode = visit.getStatusCode();
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public LocalDateTime getReceiptDateTime() {
        return receiptDateTime;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
