package edu.kalum.enrollmentmanagement.core.service;

import edu.kalum.enrollmentmanagement.core.dto.EnrollmentRequest;
import edu.kalum.enrollmentmanagement.core.dto.EnrollmentResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EntityManager entityManager;

    public EnrollmentResponse executeProcedure(EnrollmentRequest enrollmentRequest) {
        StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("sp_enrollment_student");
        procedure.registerStoredProcedureParameter("_file_number", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("_cycle", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("_month_start", Integer.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("_career_id", String.class, ParameterMode.IN);

        procedure.registerStoredProcedureParameter("_status_code",Integer.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("_message", String.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("_student_id", String.class, ParameterMode.OUT);

        procedure.setParameter("_file_number",enrollmentRequest.getFileNumber());
        procedure.setParameter("_cycle", enrollmentRequest.getCycle());
        procedure.setParameter("_month_start", enrollmentRequest.getMonthStart());
        procedure.setParameter("_career_id",enrollmentRequest.getCareerId());

        procedure.execute();

        Integer statusCode = (Integer) procedure.getOutputParameterValue("_status_code");
        String message = (String) procedure.getOutputParameterValue("_message");
        String studentId = (String) procedure.getOutputParameterValue("_student_id");

        return new EnrollmentResponse(statusCode,message,studentId);

    }

}
