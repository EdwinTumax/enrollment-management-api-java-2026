package edu.kalum.enrollmentmanagement.core.controller;

import edu.kalum.enrollmentmanagement.core.dto.EnrollmentRequest;
import edu.kalum.enrollmentmanagement.core.dto.EnrollmentResponse;
import edu.kalum.enrollmentmanagement.core.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollment-management/v1/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponse> executeEnrollmentStudent(@RequestBody EnrollmentRequest enrollmentRequest) {
        EnrollmentResponse response = null;
        try {
            response = enrollmentService.executeProcedure(enrollmentRequest);
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }catch (Exception ex) {
            response = new EnrollmentResponse(503,"TRANSACTION ERROR","0");
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }
}
