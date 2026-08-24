package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.services.PrescriptionService;
import com.project.back_end.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final TokenService tokenService;

    public PrescriptionController(PrescriptionService prescriptionService, TokenService tokenService) {
        this.prescriptionService = prescriptionService;
        this.tokenService = tokenService;
    }

    @PostMapping("/{token}")
    public ResponseEntity<Map<String, String>> addPrescription(
            @PathVariable String token,
            @Valid @RequestBody Prescription prescription) {

        Map<String, String> response = new HashMap<>();

        if (!tokenService.validateToken(token, "doctor")) {
            response.put("message", "Invalid or expired token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        prescriptionService.savePrescription(prescription);
        response.put("message", "Prescription added successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
