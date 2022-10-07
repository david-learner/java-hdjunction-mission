package com.hdjunction.patient.management.repository.dto;

/**
 * 환자 목록 조회시 환자정보를 제공하기 위한 Projection용 DTO
 * 메서드명 get 이후 이름이 대소문자 구분되어 json의 key로 사용된다.
 */
public interface ICustomPatientFlatDto {

    // 환자이름
    String getName();
    // 환자등록번호
    String getregistration_number();
    // 성별코드
    String getsex_code();
    // 휴대폰번호
    String getmobile_phone_number();
    // 최근방문일
    String getrecent_receipt_date_time();
}
