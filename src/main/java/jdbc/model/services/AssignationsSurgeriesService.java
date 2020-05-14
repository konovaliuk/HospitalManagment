package jdbc.model.services;

import jdbc.model.dao.AssignationsSurgeriesDao;
import jdbc.model.dao.DaoConnection;
import jdbc.model.dao.DaoFactory;
import jdbc.model.entities.AssignationsSurgeries;

import java.sql.Connection;
import java.util.List;

public class AssignationsSurgeriesService {

    private Connection connection;

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder {
        static final AssignationsSurgeriesService INSTANCE = new AssignationsSurgeriesService();
    }

    public static AssignationsSurgeriesService getInstance() {
        return Holder.INSTANCE;
    }

    /* Service methods */

    public List<AssignationsSurgeries> getAssignationSurgeriesByDiagnosisHistoryIdList(int diagnosisHistoryId) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            AssignationsSurgeriesDao assignationsSurgeriesDao = daoFactory.createAssignationsSurgeriesDao(connection);
            return assignationsSurgeriesDao.findByDiagnosisHistoryId(diagnosisHistoryId);
        }
    }

    public void createAssignationsSurgeries(List<AssignationsSurgeries> assignationsProceduresList) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            connection.begin();
            AssignationsSurgeriesDao assignationsSurgeriesDao = daoFactory.createAssignationsSurgeriesDao(connection);
            for (AssignationsSurgeries assignationsProcedures : assignationsProceduresList) {
                assignationsSurgeriesDao.create(assignationsProcedures);
            }
            connection.commit();
        }
    }

}

