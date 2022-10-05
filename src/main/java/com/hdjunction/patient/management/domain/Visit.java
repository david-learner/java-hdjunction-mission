package com.hdjunction.patient.management.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

// 환자방문
@Entity
public class Visit {

    // 환자방문 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 병원 ID
    @ManyToOne
    @JoinColumn(unique = true)
    private Hospital hospital;
    // 환자 ID
    @ManyToOne
    @JoinColumn(unique = true)
    private Patient patient;
    // 접수일시
    @Column(nullable = false)
    private LocalDateTime receiptDateTime;
    // 방문상태코드
    @Column(length = 10, nullable = false)
    private String statusCode;

    protected Visit() {
    }

    public Visit(Hospital hospital, Patient patient, LocalDateTime receiptDateTime, String statusCode) {
        this.hospital = hospital;
        this.patient = patient;
        this.receiptDateTime = receiptDateTime;
        this.statusCode = statusCode;
    }

    public Long getId() {
        return id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getReceiptDateTime() {
        return receiptDateTime;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
