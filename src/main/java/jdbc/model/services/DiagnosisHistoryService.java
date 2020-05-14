package jdbc.model.services;

import jdbc.model.dao.DaoConnection;
import jdbc.model.dao.DaoFactory;
import jdbc.model.dao.DiagnosisHistoryDao;
import jdbc.model.entities.DiagnosisHistory;

import java.util.List;

public class DiagnosisHistoryService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder {
        static final DiagnosisHistoryService INSTANCE = new DiagnosisHistoryService();
    }

    public static DiagnosisHistoryService getInstance() {
        return Holder.INSTANCE;
    }

    /* Service methods */

    public List<DiagnosisHistory> getDiagnosisHistoryByPatient(int id) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            DiagnosisHistoryDao diagnosisHistoryDao = daoFactory.createDiagnosisHistoryDao(connection);
            return diagnosisHistoryDao.getDiagnosisHistoryByPatientId(id);
        }
    }

    public void createDiagnosisHistory(DiagnosisHistory diagnosisHistory) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            DiagnosisHistoryDao diagnosisHistoryDao = daoFactory.createDiagnosisHistoryDao(connection);
            diagnosisHistoryDao.create(diagnosisHistory);
        }
    }

}
