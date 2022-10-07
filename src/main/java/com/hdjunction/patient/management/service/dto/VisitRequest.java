package com.hdjunction.patient.management.service.dto;

import com.hdjunction.patient.management.domain.Visit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class VisitRequest {

    private Long patientId;
    @NotBlank(message = "방문상태코드를 입력해주세요.")
    @Size(max = 10, message = "방문상태코드은 최대 10자까지 입력 가능합니다.")
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
