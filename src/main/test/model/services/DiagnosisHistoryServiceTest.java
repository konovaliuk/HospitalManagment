package jdbc.model.services;

import jdbc.model.entities.Diagnosis;
import jdbc.model.entities.DiagnosisHistory;
import jdbc.model.entities.DiagnosisType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

public class DiagnosisHistoryServiceTest {
    private DiagnosisHistoryService service;
    private DiagnosisHistory diagnoses;
    private Diagnosis diagnosis;
    private StaffService staffService;

    @Before
    public void setUp() throws Exception {
        diagnosis = new Diagnosis();
        diagnosis.setId(1);
        diagnosis.setName("Plague");
        staffService = new StaffService();

        service = new DiagnosisHistoryService();
        diagnoses = new DiagnosisHistory.Builder()
                .setId(1)
                .setDate(new Timestamp(1))
                .setDiagnosis(diagnosis)
                .setDiagnosisType(DiagnosisType.PRIMARY)
                .setPatientId(1)
                .setStaff(staffService.getStaffById(1).get())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        service = null;
        diagnoses = null;
        diagnosis = null;
        staffService = null;
    }

    @Test
    public void getDiagnosisHistoryByPatient() {
        List<DiagnosisHistory> list = service.getDiagnosisHistoryByPatient(1);

        for (DiagnosisHistory history : list) {
            assertEquals(1, history.getPatientId());
        }
    }

    @Test
    public void createDiagnosisHistory() {
        service.createDiagnosisHistory(diagnoses);

        assertEquals(diagnoses, service.getDiagnosisHistoryByPatient(diagnoses.getPatientId()));
    }
}