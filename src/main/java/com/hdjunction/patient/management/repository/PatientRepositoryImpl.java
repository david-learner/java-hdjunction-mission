package com.hdjunction.patient.management.repository;

import com.hdjunction.patient.management.repository.dto.CustomPatientDto;
import com.hdjunction.patient.management.repository.dto.PatientSearchCondition;
import com.hdjunction.patient.management.repository.dto.QCustomPatientDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.hdjunction.patient.management.domain.QPatient.patient;
import static com.hdjunction.patient.management.domain.QRecentReceiptDateTime.recentReceiptDateTime;
import static org.springframework.util.StringUtils.hasText;

public class PatientRepositoryImpl implements PatientRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public PatientRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<CustomPatientDto> search(PatientSearchCondition condition, Pageable pageable) {

        List<CustomPatientDto> patients = jpaQueryFactory
                .select(new QCustomPatientDto(
                        patient.name,
                        patient.registrationNumber,
                        patient.sexCode,
                        patient.mobilePhoneNumber,
                        patient.dateOfBirth,
                        recentReceiptDateTime.receiptDateTime
                ))
                .from(patient)
                .leftJoin(recentReceiptDateTime)
                .on(patient.id.eq(recentReceiptDateTime.id))
                .where(
                        patientNameContains(condition.getName()),
                        registrationNumberContains(condition.getRegistrationNumber()),
                        dateOfBirthContains(condition.getDateOfBirth())
                )
                .offset(getOffset(pageable))
                .limit(getPageSize(pageable))
                .orderBy(patient.name.asc())
                .fetch();

        return new PageImpl<>(patients, pageable, patients.size());
    }

    private long getOffset(Pageable pageable) {
        return pageable != null ? pageable.getOffset() : null;
    }

    private long getPageSize(Pageable pageable) {
        return pageable != null ? pageable.getPageSize() : null;
    }

    private BooleanExpression patientNameContains(String patientName) {
        return hasText(patientName) ? patient.name.contains(patientName) : null;
    }

    private BooleanExpression registrationNumberContains(String registrationNumber) {
        return hasText(registrationNumber) ? patient.registrationNumber.contains(registrationNumber) : null;
    }

    private BooleanExpression dateOfBirthContains(String dateOfBirth) {
        return hasText(dateOfBirth) ? patient.dateOfBirth.contains(dateOfBirth) : null;
    }
}
