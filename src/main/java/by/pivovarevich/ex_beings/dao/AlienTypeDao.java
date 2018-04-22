package by.pivovarevich.ex_beings.dao;

import by.pivovarevich.ex_beings.entity.Alien;
import by.pivovarevich.ex_beings.entity.AlienType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlienTypeDao extends AbstractDAO<AlienType> {

    private static final String SQL_SELECT_ALIEN_TYPES =
            "SELECT name, description FROM alientype";
    private static final String SQL_SELECT_ALIENS_IN_TYPE=
            "SELECT id, name, place, food, dangers, appearance, feature FROM alien WHERE type = " +
                    "(SELECT id FROM alientype WHERE name=?)";

    @Override
    public List<AlienType> findAll() throws SQLException {
        List<AlienType> alienTypes = new ArrayList<>();

        PreparedStatement statement = getPreparedStatement(SQL_SELECT_ALIEN_TYPES);
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AlienType alienType = new AlienType();
                alienType.setName(resultSet.getString("name"));
                alienType.setDescription(resultSet.getString("description"));

                alienTypes.add(alienType);
            }
        } finally {
            closeStatement(statement);
        }
        return alienTypes;
    }

    @Override
    public AlienType findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(AlienType entity) {
        return false;
    }

    @Override
    public boolean create(AlienType entity) {
        return false;
    }

    @Override
    public AlienType update(AlienType entity) {
        return null;
    }

    public List<Alien> findAliensInType(String alienTypeName) throws SQLException {
        List<Alien> aliens = new ArrayList<>();
        Alien alien;

        PreparedStatement statement = getPreparedStatement(SQL_SELECT_ALIENS_IN_TYPE);
        try {
            statement.setString(1, alienTypeName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                alien = new Alien();
                alien.setId(resultSet.getInt("id"));
                alien.setName(resultSet.getString("name"));
                alien.setPlace(resultSet.getString("place"));
                alien.setFood(resultSet.getString("food"));
                alien.setDangers(resultSet.getString("dangers"));
                alien.setAppearance(resultSet.getString("appearance"));
                alien.setFeature(resultSet.getString("feature"));

                aliens.add(alien);
            }
        } finally {
            closeStatement(statement);
        }
        return aliens;
    }
}
