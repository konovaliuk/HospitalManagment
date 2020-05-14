package jdbc.model.dao;

import jdbc.model.entities.DiagnosisHistory;

import java.util.List;

public interface DiagnosisHistoryDao extends GenericDao<DiagnosisHistory> {
    List<DiagnosisHistory> getDiagnosisHistoryByPatientId(int patientId);
}
