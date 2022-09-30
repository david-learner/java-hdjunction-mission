package com.hdjunction.patient.management.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

// 환자방문
@Entity
public class Visit {

    // 환자방문 ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
