package com.hdjunction.patient.management.repository.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

/**
 * 환자 목록 검색 조건
 */
public class PatientSearchCondition {

    public static final String INVALID_PAGE_NO_EXCEPTION_MESSAGE = "페이지는 1페이지부터 시작합니다.";
    private String name;
    private String registrationNumber;
    private String dateOfBirth;
    private Integer pageNo;
    private Integer pageSize;

    public PatientSearchCondition(String name, String registrationNumber, String dateOfBirth, Integer pageSize, Integer pageNo) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.dateOfBirth = dateOfBirth;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Pageable toPageable() {
        if (Objects.isNull(this.pageSize) || Objects.isNull(this.pageNo)) {
            return null;
        }
        if (this.pageNo < 1) {
            throw new IllegalArgumentException(INVALID_PAGE_NO_EXCEPTION_MESSAGE);
        }
        int pageNoForJpa = this.pageNo - 1;
        return PageRequest.of(pageNoForJpa, this.pageSize);
    }
}
