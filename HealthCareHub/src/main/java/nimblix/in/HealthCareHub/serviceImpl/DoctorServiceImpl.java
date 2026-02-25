package nimblix.in.HealthCareHub.serviceImpl;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.model.Doctor;
import nimblix.in.HealthCareHub.repository.DoctorRepository;
import nimblix.in.HealthCareHub.response.DoctorResponse;
import nimblix.in.HealthCareHub.response.LabResultDoctorResponse;
import nimblix.in.HealthCareHub.service.DoctorService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public DoctorResponse getDoctorDetails(Long doctorId, Long hospitalId) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Validate hospital
        if (doctor.getHospital() == null ||
                !doctor.getHospital().getId().equals(hospitalId)) {

            throw new RuntimeException("Doctor does not belong to given hospital");
        }

        DoctorResponse dto = new DoctorResponse();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setExperienceYears(doctor.getExperienceYears());
        dto.setPhone(doctor.getPhone());
        dto.setQualification(doctor.getQualification());

        if (doctor.getHospital() != null) {
            dto.setHospitalId(doctor.getHospital().getId());
        }

        if (doctor.getSpecialization() != null) {
            dto.setSpecializationId(doctor.getSpecialization().getId());
            dto.setSpecialization(doctor.getSpecialization().getName());
        }

        return dto;
    }
}