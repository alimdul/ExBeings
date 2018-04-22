package by.pivovarevich.ex_beings.dao;

import by.pivovarevich.ex_beings.connection.ConnectionPool;
import by.pivovarevich.ex_beings.connection.ProxyConnection;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class TransactionHelper {

    private static final Logger LOGGER = LogManager.getLogger();

    private ProxyConnection connection = ConnectionPool.getInstance().getConnection();

    public void beginTransaction(AbstractDAO dao, AbstractDAO ... daos) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            LOGGER.log(Level.WARN, "- Can not set autocommit false");// мб какой-то exception
        }
        dao.setConnection(connection);
        for(AbstractDAO currentDAO: daos) {
            currentDAO.setConnection(connection);
        }
    }

    public void endTransaction() {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.log(Level.WARN, "- Can not set autocommit true");// мб какой-то exception
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            LOGGER.log(Level.WARN, "- Can not make rollback");// мб какой-то exception
        }
    }
}
