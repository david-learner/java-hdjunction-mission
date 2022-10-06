package com.hdjunction.patient.management.api.dto;

import com.hdjunction.patient.management.domain.Patient;

public class PatientFlatDto {

    private Long patientId;
    private String patientName;
    private String registrationNumber;
    private String sexCode;
    private String dateOfBirth;
    private String mobilePhoneNumber;
    private HospitalFlatDto hospital;

    public PatientFlatDto(Patient patient) {
        this.patientId = patient.getId();
        this.patientName = patient.getName();
        this.registrationNumber = patient.getRegistrationNumber();
        this.sexCode = patient.getSexCode();
        this.dateOfBirth = patient.getDateOfBirth();
        this.mobilePhoneNumber = patient.getMobilePhoneNumber();
        this.hospital = new HospitalFlatDto(patient.getHospital());
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
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

    public HospitalFlatDto getHospital() {
        return hospital;
    }
}
