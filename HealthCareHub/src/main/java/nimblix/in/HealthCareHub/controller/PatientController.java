package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import nimblix.in.HealthCareHub.model.Patient;
import nimblix.in.HealthCareHub.repository.PatientRepository;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    // ✅ Create Patient
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // ✅ Get All Patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // ✅ Get Patient By ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}