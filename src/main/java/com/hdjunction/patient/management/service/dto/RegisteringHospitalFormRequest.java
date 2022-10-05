package com.hdjunction.patient.management.service.dto;

import com.hdjunction.patient.management.domain.Hospital;

public class RegisteringHospitalFormRequest {

    private String hospitalName;
    private String nursingInstitutionNumber;
    private String directorName;

    private RegisteringHospitalFormRequest() {
    }

    public RegisteringHospitalFormRequest(String hospitalName, String nursingInstitutionNumber, String directorName) {
        this.hospitalName = hospitalName;
        this.nursingInstitutionNumber = nursingInstitutionNumber;
        this.directorName = directorName;
    }

    public Hospital toHospital() {
        return new Hospital(this.hospitalName, this.nursingInstitutionNumber, this.directorName);
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getNursingInstitutionNumber() {
        return nursingInstitutionNumber;
    }

    public void setNursingInstitutionNumber(String nursingInstitutionNumber) {
        this.nursingInstitutionNumber = nursingInstitutionNumber;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
