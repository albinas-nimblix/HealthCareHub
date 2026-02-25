package nimblix.in.HealthCareHub.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DoctorRequest {

    @NotBlank
    private String name;

    private Integer experienceYears;

    private String phone;

    private String qualification;

    @NotNull
    private Long hospitalId;

    @NotNull
    private Long specializationId;

    @NotNull
    private Long userId;
}