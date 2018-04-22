package by.pivovarevich.ex_beings.dao;

import by.pivovarevich.ex_beings.connection.ProxyConnection;
import by.pivovarevich.ex_beings.entity.Entity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<T extends Entity> {

    private static final Logger LOGGER = LogManager.getLogger();

    protected ProxyConnection connection;

    public abstract List<T> findAll() throws SQLException;
    public abstract T findEntityById(int id);
    public abstract boolean delete(int id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);

    public PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            LOGGER.log(Level.WARN, "- Can not create PreparedStatement");
        }
        return statement;
    }

    public void closeStatement(Statement statement) {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARN, "- Can not close statement");
            }
        }
    }

    void setConnection(ProxyConnection connection) {
        this.connection = connection;
    }
}
