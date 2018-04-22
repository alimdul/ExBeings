package by.pivovarevich.ex_beings.dao;

import by.pivovarevich.ex_beings.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    private static final String SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT id, login, password, mail, isAdmin FROM user WHERE login=? AND password=sha1(?)";
    private static final String SQL_INSERT_USER =
            "INSERT INTO user (login, password, mail, isAdmin) VALUES (?, sha1(?), ?, ?)";

    private static final String NOT_ADMIN = "N";

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    public User findUserByLoginAndPassword(String login, String password) throws SQLException {
        User user = null;

        PreparedStatement statement = getPreparedStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD);
        try {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setMail(resultSet.getString("mail"));
                String fieldIsAdmin = resultSet.getString("isAdmin");
                if (NOT_ADMIN.equals(fieldIsAdmin)) {
                    user.setAdmin(false);
                } else {
                    user.setAdmin(true);
                }
            }
        }  finally {
            closeStatement(statement);
        }
        return user;
    }

    public boolean isAdmin(String login, String password) {
        return false;
    }

    public void addUser(String login, String password, String mail) throws SQLException {
        PreparedStatement statement = getPreparedStatement(SQL_INSERT_USER);
        try {
            statement.setString(1, login);
            statement.setString(2, password);
            statement.setString(3, mail);
            statement.setString(4, NOT_ADMIN);
            statement.executeUpdate();
        } finally {
            closeStatement(statement);
        }
    }
}
