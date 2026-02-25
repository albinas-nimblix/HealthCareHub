package nimblix.in.HealthCareHub.response;

import lombok.Data;

@Data
public class LabResultResponse {

    private Long id;
    private String testName;
    private String resultValue;
    private String status;
    private String uploadedAt;
    private LabResultPatientResponse patient;
    private LabResultDoctorResponse doctor;
}