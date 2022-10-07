package com.hdjunction.patient.management.repository;

import com.hdjunction.patient.management.domain.Patient;
import com.hdjunction.patient.management.repository.dto.CustomPatientFlatDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     *
     */
    @Query(value = """
                SELECT * FROM patient p
                left join (
                    SELECT 
                        CAST(receipt_date_time AS DATE) as recent_receipt_date_time,
                        patient_id,
                        rank() over (partition by patient_Id order by receipt_date_time desc) as rank 
                    from visit
                ) as vi
                on vi.patient_id = p.id where vi.rank = 1
            """, nativeQuery = true)
    List<CustomPatientFlatDto> findAllPatientsWithRecentReceiptDateTime();
}
