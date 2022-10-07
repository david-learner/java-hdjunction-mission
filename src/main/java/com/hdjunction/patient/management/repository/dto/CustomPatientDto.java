package com.hdjunction.patient.management.repository.dto;

import com.querydsl.core.annotations.QueryProjection;

import java.time.LocalDateTime;

public class CustomPatientDto {

    private String name;
    private String registrationNumber;
    private String sexCode;
    private String mobilePhoneNumber;
    private String dateOfBirth;
    private LocalDateTime recentReceiptDateTime;

    @QueryProjection
    public CustomPatientDto(String name, String registrationNumber, String sexCode, String mobilePhoneNumber, String dateOfBirth, LocalDateTime recentReceiptDateTime) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.sexCode = sexCode;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.recentReceiptDateTime = recentReceiptDateTime;
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

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getRecentReceiptDateTime() {
        return recentReceiptDateTime;
    }
}
