package nimblix.in.HealthCareHub.response;

import lombok.Data;

@Data
public class LabResultPatientResponse {

    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private String phone;
    private String disease;
}