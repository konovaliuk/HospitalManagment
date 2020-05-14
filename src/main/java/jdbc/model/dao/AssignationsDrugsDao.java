package jdbc.model.dao;

import jdbc.model.entities.AssignationsDrugs;

import java.util.List;

public interface AssignationsDrugsDao extends GenericDao<AssignationsDrugs> {
    List<AssignationsDrugs> findByDiagnosisHistoryId(int diagnosisHistoryId);
}
