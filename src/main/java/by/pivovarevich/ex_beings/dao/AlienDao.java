package by.pivovarevich.ex_beings.dao;

import by.pivovarevich.ex_beings.entity.Alien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlienDao extends AbstractDAO<Alien> {

    private static final String SQL_SELECT_ALL_ALIENS =
            "SELECT id, name, place, food, dangers, appearance, feature FROM alien";
    private static final String SQL_SELECT_ALIEN_BY_NAME =
            "SELECT id, name, place, food, dangers, appearance, feature FROM alien WHERE name=?";

    @Override
    public List<Alien> findAll() throws SQLException {
        List<Alien> aliens = new ArrayList<>();

        PreparedStatement statement = getPreparedStatement(SQL_SELECT_ALL_ALIENS);
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Alien alien = new Alien();
                alien.setId(resultSet.getInt("id"));
                alien.setName(resultSet.getString("name"));
                alien.setPlace(resultSet.getString("place"));
                alien.setFood(resultSet.getString("food"));
                alien.setDangers(resultSet.getString("dangers"));
                alien.setAppearance(resultSet.getString("appearance"));
                alien.setFeature(resultSet.getString("feature"));

                aliens.add(alien);
            }
        }  finally {
            closeStatement(statement);
        }
        return aliens;
    }

    @Override
    public Alien findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Alien entity) {
        return false;
    }

    @Override
    public boolean create(Alien entity) {
        return false;
    }

    @Override
    public Alien update(Alien entity) {
        return null;
    }

    public Alien findAlienByName(String alienName) throws SQLException {
        Alien alien = null;

        PreparedStatement statement = getPreparedStatement(SQL_SELECT_ALIEN_BY_NAME);
        try {
            statement.setString(1, alienName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                alien = new Alien();

                alien.setId(resultSet.getInt("id"));
                alien.setName(resultSet.getString("name"));
                alien.setPlace(resultSet.getString("place"));
                alien.setFood(resultSet.getString("food"));
                alien.setDangers(resultSet.getString("dangers"));
                alien.setAppearance(resultSet.getString("appearance"));
                alien.setFeature(resultSet.getString("feature"));
            }
        } finally {
            closeStatement(statement);
        }
        return alien;
    }
}
