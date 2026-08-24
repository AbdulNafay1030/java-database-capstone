# Smart Clinic Management System - Database Schema Design

## Overview
This document outlines the MySQL relational database schema for the Smart Clinic Management System.

---

## Entity Relationship Diagrams & Tables

### 1. `users` Table
Stores authentication and base role information for system access (Admin, Doctor, Patient).

```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role VARCHAR(20) NOT NULL, -- ADMIN, DOCTOR, PATIENT
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 2. `doctors` Table
Stores detailed profiles and specialties of medical professionals.

```sql
CREATE TABLE doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20),
    user_id BIGINT UNIQUE,
    CONSTRAINT fk_doctor_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```

### 3. `patients` Table
Stores patient demographic and medical profile details.

```sql
CREATE TABLE patients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20),
    date_of_birth DATE,
    gender VARCHAR(10),
    user_id BIGINT UNIQUE,
    CONSTRAINT fk_patient_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```

### 4. `appointments` Table
Tracks patient consultations booked with doctors.

```sql
CREATE TABLE appointments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id BIGINT NOT NULL,
    doctor_id BIGINT NOT NULL,
    appointment_date DATETIME NOT NULL,
    status VARCHAR(20) DEFAULT 'SCHEDULED', -- SCHEDULED, COMPLETED, CANCELLED
    notes TEXT,
    CONSTRAINT fk_appointment_patient FOREIGN KEY (patient_id) REFERENCES patients(id),
    CONSTRAINT fk_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
```

### 5. `prescriptions` Table
Contains prescription details issued by doctors after an appointment.

```sql
CREATE TABLE prescriptions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    appointment_id BIGINT UNIQUE NOT NULL,
    medication TEXT NOT NULL,
    dosage VARCHAR(100) NOT NULL,
    instructions TEXT,
    issued_date DATE DEFAULT (CURRENT_DATE),
    CONSTRAINT fk_prescription_appointment FOREIGN KEY (appointment_id) REFERENCES appointments(id)
);
```

### Stored Procedures
#### Daily Appointment Report by Doctor
```sql
DELIMITER //
CREATE PROCEDURE GetDailyAppointmentReportByDoctor(
    IN report_date DATE,
    IN doc_id BIGINT
)
BEGIN
    SELECT a.id AS appointment_id, p.name AS patient_name, a.appointment_date, a.status
    FROM appointments a
    JOIN patients p ON a.patient_id = p.id
    WHERE DATE(a.appointment_date) = report_date AND a.doctor_id = doc_id;
END //
DELIMITER ;
```
