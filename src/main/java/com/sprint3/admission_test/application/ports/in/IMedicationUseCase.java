package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);

    List<Medication> getByCategoryANDdate(Long categoryId, LocalDate date);

    void createMedication(Medication medication);
}
