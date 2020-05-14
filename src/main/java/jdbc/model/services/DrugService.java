package jdbc.model.services;

import jdbc.model.dao.DaoConnection;
import jdbc.model.dao.DaoFactory;
import jdbc.model.dao.DrugDao;
import jdbc.model.entities.Drug;

import java.util.List;

public class DrugService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder {
        static final DrugService INSTANCE = new DrugService();
    }

    public static DrugService getInstance() {
        return Holder.INSTANCE;
    }

    /* Service methods */

    public List<Drug> getAllDrugs() {
        try (DaoConnection connection = daoFactory.getConnection()) {
            DrugDao drugDao = daoFactory.createDrugDao(connection);
            return drugDao.findAll();
        }
    }

}
