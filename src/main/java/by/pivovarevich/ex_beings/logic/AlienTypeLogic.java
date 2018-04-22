package by.pivovarevich.ex_beings.logic;

import by.pivovarevich.ex_beings.dao.AlienTypeDao;
import by.pivovarevich.ex_beings.dao.TransactionHelper;
import by.pivovarevich.ex_beings.entity.Alien;
import by.pivovarevich.ex_beings.entity.AlienType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlienTypeLogic {

    private static final Logger LOGGER = LogManager.getLogger();

    public List<AlienType> findAllAlienTypes() {
        List<AlienType> alienTypes = new ArrayList<>();

        AlienTypeDao alienTypeDao = new AlienTypeDao();
        TransactionHelper transactionHelper = new TransactionHelper();
        transactionHelper.beginTransaction(alienTypeDao);
        try {
            alienTypes = alienTypeDao.findAll();
            transactionHelper.commit();
        } catch (SQLException e) {
            transactionHelper.rollback();
            LOGGER.log(Level.WARN, "- SQLException (findAlienByName in AlienDao or commit)");
        } finally {
            transactionHelper.endTransaction();
        }
        return alienTypes;
    }

    public List<Alien> findAliensInType(String alienTypeName) {
        List<Alien> aliens = new ArrayList<>();

        AlienTypeDao alienTypeDao = new AlienTypeDao();
        TransactionHelper transactionHelper = new TransactionHelper();
        transactionHelper.beginTransaction(alienTypeDao);
        try {
            aliens = alienTypeDao.findAliensInType(alienTypeName);
            transactionHelper.commit();
        } catch (SQLException e) {
            transactionHelper.rollback();
            LOGGER.log(Level.WARN, "- SQLException (findAlienByName in AlienDao or commit)");
        } finally {
            transactionHelper.endTransaction();
        }
        return aliens;
    }
}
