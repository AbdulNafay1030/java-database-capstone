# User Stories - Smart Clinic Management System

## Patient User Stories

### US-01: Patient Account Registration
* **Title:** Account Creation
* **As a:** Patient
* **I want to:** Register for an account using my email, full name, phone number, and password
* **So that:** I can access the patient portal and schedule medical appointments.
* **Acceptance Criteria:** 
  - System validates unique email addresses.
  - Password must be at least 8 characters long.
* **Priority:** High
* **Story Points:** 3

### US-02: Search Doctors by Specialty
* **Title:** Doctor Search
* **As a:** Patient
* **I want to:** Search for doctors by name or specialty
* **So that:** I can find a suitable healthcare provider for my needs.
* **Acceptance Criteria:**
  - Search bar allows partial matching by name or specialty.
  - Results display doctor name, specialty, and availability.
* **Priority:** High
* **Story Points:** 5

---

## Doctor User Stories

### US-03: View Daily Appointment Schedule
* **Title:** View Appointments
* **As a:** Doctor
* **I want to:** View my daily list of scheduled patient appointments
* **So that:** I can manage my daily time and prepare for consultations.
* **Acceptance Criteria:**
  - Appointments display patient name, appointment time, and status.
  - Doctor can filter appointments by date.
* **Priority:** High
* **Story Points:** 5

### US-04: Issue Patient Prescriptions
* **Title:** Create Prescription
* **As a:** Doctor
* **I want to:** Create and attach a prescription to a completed appointment
* **So that:** The patient can view their prescribed medications.
* **Acceptance Criteria:**
  - Form requires medication name, dosage, and instructions.
  - Prescription attaches directly to the appointment ID.
* **Priority:** Medium
* **Story Points:** 5

---

## Admin User Stories

### US-05: Add New Doctor Profile
* **Title:** Add Doctor
* **As an:** Admin
* **I want to:** Add a new doctor to the system database
* **So that:** Patients can start booking appointments with them.
* **Acceptance Criteria:**
  - Admin can fill out name, specialty, email, and credentials.
  - System verifies email uniqueness and saves doctor to the system.
* **Priority:** High
* **Story Points:** 3
