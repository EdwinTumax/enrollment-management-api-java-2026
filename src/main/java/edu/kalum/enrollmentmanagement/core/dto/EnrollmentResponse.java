package edu.kalum.enrollmentmanagement.core.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponse {
    private int statusCode;
    private String messageTransaction;
    private String studentId;
}
