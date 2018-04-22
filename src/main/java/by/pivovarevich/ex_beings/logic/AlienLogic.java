package by.pivovarevich.ex_beings.logic;

import by.pivovarevich.ex_beings.dao.AlienDao;
import by.pivovarevich.ex_beings.dao.TransactionHelper;
import by.pivovarevich.ex_beings.entity.Alien;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlienLogic {

    private static final Logger LOGGER = LogManager.getLogger();

    public List<Alien> findAllAliens() {
        List<Alien> aliens = new ArrayList<>();

        AlienDao alienDao = new AlienDao();
        TransactionHelper transactionHelper = new TransactionHelper();
        transactionHelper.beginTransaction(alienDao);
        try {
            aliens = alienDao.findAll();
            transactionHelper.commit();
        } catch (SQLException e) {
            transactionHelper.rollback();
            LOGGER.log(Level.WARN, "- SQLException (findAll in AlienDao or commit)");
        } finally {
            transactionHelper.endTransaction();
        }
        return aliens;
    }

    public Alien findAlienByName(String alienName) {
        Alien alien = null;

        AlienDao alienDao = new AlienDao();
        TransactionHelper transactionHelper = new TransactionHelper();
        transactionHelper.beginTransaction(alienDao);
        try {
            alien = alienDao.findAlienByName(alienName);
            transactionHelper.commit();
        } catch (SQLException e) {
            transactionHelper.rollback();
            LOGGER.log(Level.WARN, "- SQLException (findAlienByName in AlienDao or commit)");
        } finally {
            transactionHelper.endTransaction();
        }
        return alien;
    }
}
