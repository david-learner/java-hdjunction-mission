package com.hdjunction.patient.management.domain;

import javax.persistence.*;

// 환자
@Entity
public class Patient {

    // 환자ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // 병원ID
    @ManyToOne
    @JoinColumn(unique = true)
    private Hospital hospital;
    // 환자명
    @Column(length = 45, nullable = false)
    private String name;
    // 환자등록번호
    @Column(length = 13, nullable = false)
    private String registrationNumber;
    // 성별코드
    @Column(length = 10, nullable = false)
    private String sexCode;
    // 생년월일
    @Column(length = 10)
    private String dateOfBirth;
    // 휴대전화번호
    @Column(length = 20)
    private String mobilePhoneNumber;
}
