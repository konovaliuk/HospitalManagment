package jdbc.model.services;

import jdbc.model.dao.DaoConnection;
import jdbc.model.dao.DaoFactory;
import jdbc.model.dao.SurgeryDao;
import jdbc.model.entities.Surgery;

import java.util.List;

public class SurgeryService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder {
        static final SurgeryService INSTANCE = new SurgeryService();
    }

    public static SurgeryService getInstance() {
        return Holder.INSTANCE;
    }

    /* Service methods */

    public List<Surgery> getAllSurgeries() {
        try (DaoConnection connection = daoFactory.getConnection()) {
            SurgeryDao surgeryDao = daoFactory.createSurgeryDao(connection);
            return surgeryDao.findAll();
        }
    }
}
