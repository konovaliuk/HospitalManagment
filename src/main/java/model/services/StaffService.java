package model.services;

import java.util.Optional;

import model.dao.DaoConnection;
import model.dao.DaoFactory;
import model.dao.StaffDao;
import model.entities.Staff;

public class StaffService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder {
        static final StaffService INSTANCE = new StaffService();
    }

    public static StaffService getInstance() {
        return Holder.INSTANCE;
    }

    /* Service methods */

    public Optional<Staff> login(String email, String password) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            StaffDao staffDao = daoFactory.createStaffDao(connection);
            return staffDao.getStaffByEmail(email)
                    .filter(staff -> password.equals(staff.getPassword()));
        }
    }

    public Optional<Staff> register (String firstName, String lastName,
                                     String surName, Staff.Role role, String email, String password) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            StaffDao staffDao = daoFactory.createStaffDao(connection);
            Staff staff = new Staff.Builder()
                    .setId(1)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setSurName(surName)
                    .setRole(role)
                    .setEmail(email)
                    .setPassword(password)
                    .build();
            staffDao.create(staff);

            return staffDao.getStaffByEmail(email)
                    .filter(s -> password.equals(s.getPassword()));
        }
    }

    public Optional<Staff> getStaffById(int Id) {
        try (DaoConnection connection = daoFactory.getConnection()) {
            StaffDao staffDao = daoFactory.createStaffDao(connection);
            return staffDao.find(Id);
        }
    }

}
