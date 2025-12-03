package com.sprint3.admission_test.infrastructure.adapter.out.persistence.repositoryImpl;

import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.MedicationJpaRepository;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MedicationRepositoryImpl implements IMedicationRepository {

    @Autowired
    private MedicationJpaRepository medicationJpaRepository;

    @Override
    public Optional<Medication> findById(Long id) {
        return medicationJpaRepository.findById(id);
    }

   @Override
   public List<Medication> findByExpiration(LocalDate date) {
       return  medicationJpaRepository.findByExpirationDate(date);
   }

   @Override
   public List<Medication> findByCategory(Long categoryId){
       return medicationJpaRepository.findByCategory(String.valueOf(categoryId));
   }

    @Override
    public void createMedication(Medication medication) {
        medicationJpaRepository.createMedication(medication);
    }

}
