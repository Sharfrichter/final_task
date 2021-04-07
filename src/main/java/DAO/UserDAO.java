package DAO;

import ConnectionPool.ConnectionPool;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements EntityDAO<User, Integer> {
    private Connection connection;

    public UserDAO() {
        connection = null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        while (connection == null) {
            connection = ConnectionPool.INSTANCE.getAvailableConnection();
        }
        try (Statement statement = connection.createStatement()) {
            statement.execute("SELECT * FROM users");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int roleId = resultSet.getInt("role_id");
                users.add(new User(id, login, password, firstName, lastName,roleId));

            }
            connection.close();
            connection = null;
        } catch (SQLException throwables) {
            //todo
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(Integer id) {
        User user=null;
        while (connection == null) {
            connection = ConnectionPool.INSTANCE.getAvailableConnection();
        }
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id=?")) {
            statement.setInt(1,id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int roleId = resultSet.getInt("role_id");
            user=new User(id,login,password,firstName,lastName,roleId);
            connection.close();
            connection = null;
        } catch (SQLException throwables) {
            //todo
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
            throwables.printStackTrace();
        }

        return user;
    }


    @Override
    public User update(User user) {
        while (connection == null) {
            connection = ConnectionPool.INSTANCE.getAvailableConnection();

        }
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE USERS SET login=?, password=?, first_name=?, last_name=?, role_id=? WHERE id=?")) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getRoleId());
            statement.setInt(6, user.getId());
            statement.executeUpdate();
            connection.close();
            connection = null;

        } catch (SQLException throwables) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) {
        while (connection == null) {
            connection = ConnectionPool.INSTANCE.getAvailableConnection();

        }
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO USERS (login,password,first_name,last_name,role_id) VALUES (?,?,?,?,?)")) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getRoleId());
            statement.executeUpdate();
            connection.close();
            connection = null;

        } catch (SQLException throwables) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        while (connection == null) {
            connection = ConnectionPool.INSTANCE.getAvailableConnection();

        }
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM USERS WHERE id=?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
            connection = null;

        } catch (SQLException throwables) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
            throwables.printStackTrace();
        }
    }
}
