package model.dao;

import model.entities.AssignationsSurgeries;

import java.util.List;

public interface AssignationsSurgeriesDao extends GenericDao<AssignationsSurgeries> {
    List<AssignationsSurgeries> findByDiagnosisHistoryId(int diagnosisHistoryId);
}
