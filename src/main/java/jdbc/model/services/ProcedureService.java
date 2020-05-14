package jdbc.model.services;

import jdbc.model.dao.DaoConnection;
import jdbc.model.dao.DaoFactory;
import jdbc.model.dao.ProcedureDao;
import jdbc.model.entities.Procedure;

import java.util.List;

public class ProcedureService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder {
        static final ProcedureService INSTANCE = new ProcedureService();
    }
    public static ProcedureService getInstance() {
        return Holder.INSTANCE;
    }

    /* Service methods */

    public List<Procedure> getAllProcedures() {
        try (DaoConnection connection = daoFactory.getConnection()) {
            ProcedureDao procedureDao = daoFactory.createProcedureDao(connection);
            return procedureDao.findAll();
        }
    }

}
