package jdbc.model.services;

import jdbc.model.dao.DaoConnection;
import jdbc.model.dao.DaoFactory;
import jdbc.model.dao.PatientDao;
import jdbc.model.entities.DiagnosisType;
import jdbc.model.entities.Patient;

import java.util.List;
import java.util.Optional;

public class PatientService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder {
        static final PatientService INSTANCE = new PatientService();
    }

    public static PatientService getInstance() {
        return Holder.INSTANCE;
    }

    /* Service methods */

    public List<Patient> getAllPatients() {
        try (DaoConnection connection = daoFactory.getConnection()) {
            PatientDao patientDao = daoFactory.createPatientDao(connection);
            return patientDao.findAll();
        }
    }

    public void createPatient(Patient patient) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            PatientDao patientDao = daoFactory.createPatientDao(connection);
            patientDao.create(patient);
        }
    }

    public Optional<Patient> getPatientById(int id) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            PatientDao patientDao = daoFactory.createPatientDao(connection);
            return patientDao.find(id);
        }
    }

    public boolean isPatientOnCure(int id) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            PatientDao patientDao = daoFactory.createPatientDao(connection);
            return patientDao.getDiagnosisType(id) == DiagnosisType.PRIMARY;
        }
    }

}
