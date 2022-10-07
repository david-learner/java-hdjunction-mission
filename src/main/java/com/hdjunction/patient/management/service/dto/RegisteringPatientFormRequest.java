package com.hdjunction.patient.management.service.dto;

import com.hdjunction.patient.management.domain.Hospital;
import com.hdjunction.patient.management.domain.Patient;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisteringPatientFormRequest {

    // 병원 ID
    @NotNull(message = "병원 ID를 입력해주세요.")
    private Long hospitalId;
    // 환자명
    @NotBlank(message = "환자 이름을 입력해주세요.")
    @Size(max = 45, message = "이름은 최대 45자까지 입력 가능합니다.")
    private String patientName;
    // 성별코드
    @NotBlank(message = "성별코드를 입력해주세요.")
    @Size(max = 10, message = "성별코드는 최대 10자까지 입력 가능합니다.")
    private String sexCode;
    // 생년월일
    private String dateOfBirth;
    // 휴대전화번호
    private String mobilePhoneNumber;

    private RegisteringPatientFormRequest() {
    }

    public RegisteringPatientFormRequest(Long hospitalId,
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
