package edu.kalum.enrollmentmanagement.core.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {
    private String fileNumber;
    private String cycle;
    private Integer monthStart;
    private String careerId;
}
