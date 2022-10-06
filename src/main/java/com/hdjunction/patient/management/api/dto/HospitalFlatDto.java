package com.hdjunction.patient.management.api.dto;

import com.hdjunction.patient.management.domain.Hospital;

public class HospitalFlatDto {

    private Long hospitalId;
    private String hospitalName;
    private String nursingInstitutionNumber;
    private String directorName;

    public HospitalFlatDto(Hospital hospital) {
        this.hospitalId = hospital.getId();
        this.hospitalName = hospital.getName();
        this.nursingInstitutionNumber = hospital.getNursingInstitutionNumber();
        this.directorName = hospital.getDirectorName();
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getNursingInstitutionNumber() {
        return nursingInstitutionNumber;
    }

    public String getDirectorName() {
        return directorName;
    }
}
