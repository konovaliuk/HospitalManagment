package jdbc.model.dao;

import jdbc.model.entities.DiagnosisType;
import jdbc.model.entities.Patient;

public interface PatientDao extends GenericDao<Patient> {
    DiagnosisType getDiagnosisType(int patientId);
}
