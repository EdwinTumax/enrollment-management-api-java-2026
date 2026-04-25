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

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollment-management/v1/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponse> executeEnrollmentStudent(@RequestBody EnrollmentRequest enrollmentRequest) {
        EnrollmentResponse response = enrollmentService.executeProcedure(enrollmentRequest);
        if(response.getStatusCode() == 201) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }
}
