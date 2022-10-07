package com.hdjunction.patient.management.repository;

import com.hdjunction.patient.management.domain.RecentReceiptDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecentReceiptDateTimeRepository extends JpaRepository<RecentReceiptDateTime, Long> {
}
