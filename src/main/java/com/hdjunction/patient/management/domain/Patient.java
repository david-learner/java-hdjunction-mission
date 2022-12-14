package com.hdjunction.patient.management.domain;

import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Objects;

// 환자
@Entity
public class Patient {

    // 환자ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 병원ID
    @ManyToOne
    private Hospital hospital;
    // 환자명
    @Column(length = 45, nullable = false)
    private String name;
    // 환자등록번호
    @GeneratorType(type = PatientRegistrationNumberGenerator.class, when = GenerationTime.INSERT)
    @Column(length = 13, unique = true, nullable = false)
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

    protected Patient() {
    }

    public Patient(Hospital hospital, String name, String sexCode, String dateOfBirth, String mobilePhoneNumber) {
        this.hospital = hospital;
        this.name = name;
        this.sexCode = sexCode;
        this.dateOfBirth = dateOfBirth;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void update(Patient patient) {
        if (Objects.nonNull(patient.hospital)) {
            this.hospital = patient.hospital;
        }
        if (Objects.nonNull(patient.name)) {
            this.name = patient.name;
        }
        if (Objects.nonNull(patient.sexCode)) {
            this.sexCode = patient.sexCode;
        }
        if (Objects.nonNull(patient.dateOfBirth)) {
            this.dateOfBirth = patient.dateOfBirth;
        }
        if (Objects.nonNull(patient.mobilePhoneNumber)) {
            this.mobilePhoneNumber = patient.mobilePhoneNumber;
        }
    }

    public Long getId() {
        return id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getSexCode() {
        return sexCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }
}
