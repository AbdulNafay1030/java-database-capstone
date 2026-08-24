package com.project.back_end.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminFrontendController {

    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "forward:/admin-login.html";
    }

    @GetMapping("/doctor/login")
    public String doctorLoginPage() {
        return "forward:/doctor-login.html";
    }

    @GetMapping("/patient/login")
    public String patientLoginPage() {
        return "forward:/patient-login.html";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboardPage() {
        return "forward:/admin-dashboard.html";
    }

    @GetMapping("/doctor/dashboard")
    public String doctorDashboardPage() {
        return "forward:/doctor-dashboard.html";
    }

    @GetMapping("/patient/dashboard")
    public String patientDashboardPage() {
        return "forward:/patient-dashboard.html";
    }
}
