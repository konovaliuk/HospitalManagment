package model.dao;

import model.entities.DiagnosisType;
import model.entities.Patient;

public interface PatientDao extends GenericDao<Patient> {
    DiagnosisType getDiagnosisType(int patientId);
}
