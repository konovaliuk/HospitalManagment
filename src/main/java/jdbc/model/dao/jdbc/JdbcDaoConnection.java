package jdbc.model.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.controller.exception.AppException;
import jdbc.model.dao.DaoConnection;
import jdbc.view.Errors;

public class JdbcDaoConnection implements DaoConnection {

    private Connection connection;
    private boolean inTransaction = false;

    JdbcDaoConnection(Connection connection) {
        super();
        this.connection = connection;
    }

    Connection getConnection() {
        return connection;
    }

    @Override
    public void close() {
        if (inTransaction) {
            rollback();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new AppException(Errors.SQL_ERROR, e);
        }
    }

    @Override
    public void begin() {
        try {
            connection.setAutoCommit(false);
            inTransaction = true;
        } catch (SQLException e) {
            throw new AppException(Errors.SQL_ERROR, e);
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
            inTransaction = false;
        } catch (SQLException e) {
            throw new AppException(Errors.SQL_ERROR, e);
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
            inTransaction = false;
        } catch (SQLException e) {
            throw new AppException(Errors.SQL_ERROR, e);
        }
    }

}
