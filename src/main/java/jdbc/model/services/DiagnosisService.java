package jdbc.model.services;

import jdbc.model.dao.DaoConnection;
import jdbc.model.dao.DaoFactory;
import jdbc.model.dao.DiagnosisDao;
import jdbc.model.entities.Diagnosis;

import java.util.List;
import java.util.Optional;

public class DiagnosisService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder {
        static final DiagnosisService INSTANCE = new DiagnosisService();
    }

    public static DiagnosisService getInstance() {
        return Holder.INSTANCE;
    }

    /* Service methods */

    public Optional<Diagnosis> getDiagnosisById(int id) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            DiagnosisDao diagnosisDao = daoFactory.createDiagnosisDao(connection);
            return diagnosisDao.find(id);
        }
    }

    public List<Diagnosis> getAllDiagnoses() {
        try (DaoConnection connection = daoFactory.getConnection()) {
            DiagnosisDao diagnosisDao = daoFactory.createDiagnosisDao(connection);
            return diagnosisDao.findAll();
        }
    }

}
