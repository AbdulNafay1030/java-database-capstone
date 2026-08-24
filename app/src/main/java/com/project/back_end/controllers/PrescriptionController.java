package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.services.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@Valid @RequestBody Prescription prescription) {
        Prescription created = prescriptionService.savePrescription(prescription);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<Prescription> getByAppointmentId(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(prescriptionService.getByAppointmentId(appointmentId));
    }
}
