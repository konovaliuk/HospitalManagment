package jdbc.model.dao.jdbc;

import java.sql.*;

import java.util.List;
import java.util.Optional;

import jdbc.controller.exception.AppException;
import jdbc.model.dao.StaffDao;
import jdbc.model.entities.Staff;
import jdbc.model.entities.Staff.Role;
import jdbc.view.Errors;

public class JdbcStaffDao implements StaffDao {

    /* SQL */
    private static final String SELECT_STAFF_BY_LOGIN = "SELECT * FROM staff WHERE lower(email) = ?";
    private static final String SELECT_STAFF_BY_ID = "SELECT * FROM staff WHERE id = ?";
    private static final String INSERT_INTO_STAFF =
            "INSERT INTO staff (lastname, firstname, surname, role, email, password) VALUES (?, ?, ?, ?, ?, ?)";

    /* Fields */
    private static final String ID = "id";
    private static final String LASTNAME = "lastname";
    private static final String FIRSTNAME = "firstname";
    private static final String SURNAME = "surname";
    private static final String ROLE = "role";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    private Connection connection;

    JdbcStaffDao(Connection connection) {
        this.connection = connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Staff> find(int id) {
        Optional<Staff> result = Optional.empty();
        try (PreparedStatement query = connection.prepareStatement(SELECT_STAFF_BY_ID)) {
            query.setString(1, String.valueOf(id));
            ResultSet resultSet = query.executeQuery();
            if (resultSet.next()) {
                Staff staff = getEntityFromResultSet(resultSet);
                result = Optional.of(staff);
            }
        } catch (SQLException ex) {
            throw new AppException(Errors.SQL_ERROR, ex);
        }
        return result;
    }

    @Override
    public List<Staff> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(Staff staff) {

        try (PreparedStatement query =
                     connection.prepareStatement(INSERT_INTO_STAFF, Statement.RETURN_GENERATED_KEYS)) {

            query.setString(1, staff.getLastName());
            query.setString(2, staff.getFirstName());
            query.setString(3, staff.getSurName());
            query.setString(4, staff.getRole().toString());
            query.setString(5, staff.getEmail());
            query.setString(6, staff.getPassword());
            query.executeUpdate();
            ResultSet keys = query.getGeneratedKeys();

            if (keys.next()) {
                staff.setId(keys.getInt(1));
            }
        } catch (SQLException e) {
            throw new AppException(Errors.SQL_ERROR, e);
        }
    }

    @Override
    public void update(Staff staff) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Staff> getStaffByEmail(String email) {
        Optional<Staff> result = Optional.empty();
        try (PreparedStatement query = connection.prepareStatement(SELECT_STAFF_BY_LOGIN)) {
            query.setString(1, email.toLowerCase());
            ResultSet resultSet = query.executeQuery();
            if (resultSet.next()) {
                Staff staff = getEntityFromResultSet(resultSet);
                result = Optional.of(staff);
            }
        } catch (SQLException ex) {
            throw new AppException(Errors.SQL_ERROR, ex);
        }
        return result;
    }

    private Staff getEntityFromResultSet(ResultSet rs) throws SQLException {
        return new Staff.Builder()
                .setId(rs.getInt(ID))
                .setLastName(rs.getString(LASTNAME))
                .setFirstName(rs.getString(FIRSTNAME))
                .setSurName(rs.getString(SURNAME))
                .setRole(Role.valueOf(rs.getString(ROLE)))
                .setEmail(rs.getString(EMAIL))
                .setPassword(rs.getString(PASSWORD))
                .build();
    }

}
