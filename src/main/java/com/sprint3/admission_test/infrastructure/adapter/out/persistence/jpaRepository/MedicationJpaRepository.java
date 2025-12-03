package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {

    List<Medication> findByExpirationDate(LocalDate date);

    List<Medication> findByCategory(String category);
}
