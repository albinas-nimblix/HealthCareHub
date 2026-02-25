package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.request.LabResultRequest;
import nimblix.in.HealthCareHub.response.LabResultResponse;
import nimblix.in.HealthCareHub.service.LabResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/lab-results")
@RequiredArgsConstructor
public class LabResultController {

    private final LabResultService labResultService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadLabResult(
            @RequestBody LabResultRequest requestDTO) {

        LabResultResponse data = labResultService.uploadLabResult(requestDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Lab result uploaded successfully");
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}