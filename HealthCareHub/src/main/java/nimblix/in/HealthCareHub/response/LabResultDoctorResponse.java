package nimblix.in.HealthCareHub.response;

import lombok.Data;

@Data
public class LabResultDoctorResponse {

    private Long id;
    private String name;
    private Integer experienceYears;
    private String phone;
    private String qualification;
    private String specialization;
}