package com.hdjunction.patient.management.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Code {

    // 코드
    @Id
    @Column(length = 10)
    private String code;
    // 코드명
    @Column(length = 10, nullable = false)
    private String name;
    // 코드그룹
    @Column(length = 10, nullable = false)
    private String codeGroup;
}
