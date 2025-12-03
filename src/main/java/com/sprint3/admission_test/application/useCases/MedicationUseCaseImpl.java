package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationUseCaseImpl implements IMedicationUseCase {

    @Autowired
    private IMedicationRepository medicationRepository;

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    public List<Medication> getByCategoryANDdate(Long categoryId, LocalDate date){
        List<Medication> found = new ArrayList<Medication>();
        List<Medication> foundByCategory = new ArrayList<Medication>();
        List<Medication> foundByDate = new ArrayList<Medication>();

        foundByCategory = medicationRepository.findByCategory(categoryId);
        foundByDate = medicationRepository.findByExpiration(date);

        found.addAll(foundByDate);
        found.addAll(foundByCategory);

        return found;
    }

    @Override
    public void createMedication(Medication medication){
        medicationRepository.createMedication(medication);
    }

}
