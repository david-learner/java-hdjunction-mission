package com.hdjunction.patient.management.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

// 최근 내원일시
@Entity
public class RecentReceiptDateTime {

    public static final String INVALID_RECENT_RECEIPT_DATETIME_MESSAGE = "최근 방문일시가 유효하지 않습니다.";

    @Id
    @Column(name = "patient_id")
    private Long id;
    // 환자정보
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "patient_id")
    private Patient patient;
    // 최근 내원일시
    @Column(nullable = false)
    private LocalDateTime receiptDateTime;

    protected RecentReceiptDateTime() {
    }

    public RecentReceiptDateTime(Patient patient, LocalDateTime receiptDateTime) {
        this.patient = patient;
        this.receiptDateTime = receiptDateTime;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getReceiptDateTime() {
        return receiptDateTime;
    }

    public void updateReceiptDateTime(LocalDateTime newReceiptDateTime) {
        if (this.receiptDateTime.isAfter(newReceiptDateTime)) {
            throw new IllegalArgumentException(INVALID_RECENT_RECEIPT_DATETIME_MESSAGE);
        }
        this.receiptDateTime = newReceiptDateTime;
    }
}
