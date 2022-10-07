package com.hdjunction.patient.management.repository.dto;

public class PatientSearchCondition {

    private String name;
    private String registrationNumber;
    private String dateOfBirth;

    public PatientSearchCondition(String name, String registrationNumber, String dateOfBirth) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
