package jdbc.model.dao;

import jdbc.model.entities.AssignationsProcedures;

import java.util.List;

public interface AssignationsProceduresDao extends GenericDao<AssignationsProcedures> {
    List<AssignationsProcedures> findByDiagnosisHistoryId(int diagnosisHistoryId);
}
