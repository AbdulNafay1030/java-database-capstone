package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getDoctorsBySpecialty(String specialty) {
        return doctorRepository.findBySpecialtyIgnoreCase(specialty);
    }

    public List<String> getDoctorAvailability(Long doctorId, String date) {
        Optional<Doctor> doctorOpt = doctorRepository.findById(doctorId);
        if (doctorOpt.isPresent()) {
            Doctor doctor = doctorOpt.get();
            return doctor.getAvailableTimes();
        }
        return new ArrayList<>();
    }

    public boolean validateDoctorLogin(String email, String password) {
        // Simple credential validation logic
        Optional<Doctor> doctorOpt = doctorRepository.findAll().stream()
                .filter(d -> d.getEmail().equalsIgnoreCase(email))
                .findFirst();
        return doctorOpt.isPresent();
    }
}
