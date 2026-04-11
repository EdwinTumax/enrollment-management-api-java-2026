package edu.kalum.enrollmentmanagement.core.controller;

import edu.kalum.enrollmentmanagement.core.dto.EnrollmentRequest;
import edu.kalum.enrollmentmanagement.core.dto.EnrollmentResponse;
import edu.kalum.enrollmentmanagement.core.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
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
    public EnrollmentResponse executeEnrollmentStudent(@RequestBody EnrollmentRequest enrollmentRequest) {
        return enrollmentService.executeProcedure(enrollmentRequest);
    }
}
