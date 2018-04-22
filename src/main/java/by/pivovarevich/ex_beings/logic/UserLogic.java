package by.pivovarevich.ex_beings.logic;

import by.pivovarevich.ex_beings.dao.TransactionHelper;
import by.pivovarevich.ex_beings.dao.UserDAO;
import by.pivovarevich.ex_beings.entity.User;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class UserLogic {

    private static final Logger LOGGER = LogManager.getLogger();

    public User authentication(String login, String password) {
        User user = null;

        UserDAO userDAO = new UserDAO();
        TransactionHelper transactionHelper = new TransactionHelper();
        transactionHelper.beginTransaction(userDAO);

        try {
            User foundUser = userDAO.findUserByLoginAndPassword(login, password);
            if(foundUser != null) {
                user = foundUser;
            }
            transactionHelper.commit();
        } catch (SQLException e) {
            transactionHelper.rollback();
            LOGGER.log(Level.WARN, "- SQLException (findUserByLoginAndPassword in UserDAO or commit)");
        } finally {
            transactionHelper.endTransaction();
        }
        return user;
    }

    public String authorization(User user) {
        return user.isAdmin() ? "admin" : "user";
    }

    public boolean addUser(String login, String password, String mail) {
        boolean isAdded = false;

        UserDAO userDAO = new UserDAO();
        TransactionHelper transactionHelper = new TransactionHelper();
        transactionHelper.beginTransaction(userDAO);

        try {
            userDAO.addUser(login, password, mail);
            transactionHelper.commit();
            isAdded = true;
        } catch (SQLException e) {
            transactionHelper.rollback();
            LOGGER.log(Level.WARN, "- SQLException (addUser in UserDAO or commit)");
        } finally {
            transactionHelper.endTransaction();
        }
        return isAdded;
    }
}
