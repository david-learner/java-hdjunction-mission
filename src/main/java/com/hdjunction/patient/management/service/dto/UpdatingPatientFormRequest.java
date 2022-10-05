package com.hdjunction.patient.management.service.dto;

import com.hdjunction.patient.management.domain.Hospital;
import com.hdjunction.patient.management.domain.Patient;

public class UpdatingPatientFormRequest {

    // 병원 ID
    private Long hospitalId;
    // 환자명
    private String patientName;
    // 성별코드
    private String sexCode;
    // 생년월일
    private String dateOfBirth;
    // 휴대전화번호
    private String mobilePhoneNumber;

    private UpdatingPatientFormRequest() {
    }

    public UpdatingPatientFormRequest(Long hospitalId,
                                      String patientName,
                                      String sexCode,
                                      String dateOfBirth,
                                      String mobilePhoneNumber) {
        this.hospitalId = hospitalId;
        this.patientName = patientName;
        this.sexCode = sexCode;
        this.dateOfBirth = dateOfBirth;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public String getPatientName() {
        return patientName;
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

    public Patient toPatient(Hospital hospital) {
        return new Patient(hospital, this.patientName, this.sexCode, this.dateOfBirth, this.mobilePhoneNumber);
    }
}
