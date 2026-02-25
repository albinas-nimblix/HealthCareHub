package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.response.DoctorResponse;

public interface DoctorService {

    DoctorResponse getDoctorDetails(Long doctorId, Long hospitalId);
}