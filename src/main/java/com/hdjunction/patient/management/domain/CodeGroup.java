package com.hdjunction.patient.management.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// 코드그룹
@Entity
public class CodeGroup {

    // 코드그룹
    @Id
    @Column(length = 10)
    private String codeGroup;
    // 코드그룹명
    @Column(length = 10, nullable = false)
    private String name;
    // 설명
    @Column(length = 10, nullable = false)
    private String description;
}
