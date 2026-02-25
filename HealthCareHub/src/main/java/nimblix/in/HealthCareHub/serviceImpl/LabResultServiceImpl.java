package nimblix.in.HealthCareHub.serviceImpl;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.model.Doctor;
import nimblix.in.HealthCareHub.model.LabResult;
import nimblix.in.HealthCareHub.model.Patient;
import nimblix.in.HealthCareHub.repository.DoctorRepository;
import nimblix.in.HealthCareHub.repository.LabResultRepository;
import nimblix.in.HealthCareHub.repository.PatientRepository;
import nimblix.in.HealthCareHub.request.LabResultRequest;
import nimblix.in.HealthCareHub.response.LabResultDoctorResponse;
import nimblix.in.HealthCareHub.response.LabResultPatientResponse;
import nimblix.in.HealthCareHub.response.LabResultResponse;
import nimblix.in.HealthCareHub.service.LabResultService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class LabResultServiceImpl implements LabResultService {

    private final LabResultRepository labResultRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public LabResultResponse uploadLabResult(LabResultRequest request) {

        // Fetch Patient
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Fetch Doctor
        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Create LabResult
        LabResult labResult = LabResult.builder()
                .testName(request.getTestName())
                .resultValue(request.getResultValue())
                .status(request.getStatus())
                .uploadedAt(LocalDateTime.now())
                .patient(patient)
                .doctor(doctor)
                .build();

        LabResult saved = labResultRepository.save(labResult);

        // Format date
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        LabResultResponse response = new LabResultResponse();
        response.setId(saved.getId());
        response.setTestName(saved.getTestName());
        response.setResultValue(saved.getResultValue());
        response.setStatus(saved.getStatus());
        response.setUploadedAt(saved.getUploadedAt().format(formatter));

        // Map Patient
        LabResultPatientResponse patientResponse = new LabResultPatientResponse();
        patientResponse.setId(patient.getId());
        patientResponse.setName(patient.getName());
        patientResponse.setAge(patient.getAge());
        patientResponse.setGender(patient.getGender());
        patientResponse.setPhone(patient.getPhone());
        patientResponse.setDisease(patient.getDisease());

        response.setPatient(patientResponse);

        // Map Doctor
        LabResultDoctorResponse doctorResponse = new LabResultDoctorResponse();
        doctorResponse.setId(doctor.getId());
        doctorResponse.setName(doctor.getName());
        doctorResponse.setExperienceYears(doctor.getExperienceYears());
        doctorResponse.setPhone(doctor.getPhone());
        doctorResponse.setQualification(doctor.getQualification());

        if (doctor.getSpecialization() != null) {
            doctorResponse.setSpecialization(
                    doctor.getSpecialization().getName()
            );
        }

        response.setDoctor(doctorResponse);

        return response;
    }
}