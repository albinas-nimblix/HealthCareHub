package nimblix.in.HealthCareHub.request;

import lombok.Data;

@Data
public class LabResultRequest {

    private String testName;
    private String resultValue;
    private String status;
    private Long patientId;
    private Long doctorId;
}