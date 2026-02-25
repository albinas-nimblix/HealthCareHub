package nimblix.in.HealthCareHub.response;

import lombok.Data;

@Data
public class DoctorResponse {

    private Long id;
    private String name;
    private Integer experienceYears;
    private String phone;
    private String qualification;

    private Long hospitalId;

    private Long specializationId;
    private String specialization;
}