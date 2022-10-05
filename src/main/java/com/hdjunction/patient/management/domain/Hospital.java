package com.hdjunction.patient.management.domain;

import javax.persistence.*;

// 병원
@Entity
public class Hospital {

    // 병원ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 병원명
    @Column(length = 45, nullable = false)
    private String name;
    // 요양기관번호
    @Column(length = 20, nullable = false)
    private String nursingInstitutionNumber;
    // 병원장명
    @Column(length = 10, nullable = false)
    private String directorName;

    protected Hospital() {
    }

    public Hospital(String name, String nursingInstitutionNumber, String directorName) {
        this.name = name;
        this.nursingInstitutionNumber = nursingInstitutionNumber;
        this.directorName = directorName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNursingInstitutionNumber() {
        return nursingInstitutionNumber;
    }

    public String getDirectorName() {
        return directorName;
    }
}
