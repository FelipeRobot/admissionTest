package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }
    @PostMapping
    public HttpStatus postNewMedication(@RequestBody Medication medication){
        try{
            medicationUseCase.createMedication(medication);
            return  HttpStatus.CREATED;
        }catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping("/category/{category}?expiration-after={date}")
    public ResponseEntity<List<Medication>> getByCategoryANDdate(@PathVariable Category category, @PathVariable LocalDate date){
        return  ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getByCategoryANDdate(category.getId(), date));
    }

}
