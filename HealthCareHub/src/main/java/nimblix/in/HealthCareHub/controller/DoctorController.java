package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.response.DoctorResponse;
import nimblix.in.HealthCareHub.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/getDoctorDetails")
    public ResponseEntity<DoctorResponse> getDoctorDetails(
            @RequestParam Long doctorId,
            @RequestParam Long hospitalId) {

        DoctorResponse response =
                doctorService.getDoctorDetails(doctorId, hospitalId);

        return ResponseEntity.ok(response);
    }
}