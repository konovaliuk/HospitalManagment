package model.dao;

import model.entities.AssignationsProcedures;

import java.util.List;

public interface AssignationsProceduresDao extends GenericDao<AssignationsProcedures> {
    List<AssignationsProcedures> findByDiagnosisHistoryId(int diagnosisHistoryId);
}
