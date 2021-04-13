package DAO.impl;

import ConnectionPool.ConnectionPool;
import DAO.EntityDao;
import DAO.UserDao;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {




    @Override
    public List<User> findAll() {
        if(ConnectionPool.INSTANCE.getAvailableConnections().size()==0){
            try {
                System.out.println("not available connections waiting...");
                Thread.sleep(5000);
                return this.findAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try(Connection connection=ConnectionPool.INSTANCE.getAvailableConnection()) {
                StatementCreator<User,Integer> creator = new StatementCreator<>();
              return  creator.findAll(User.class, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        if(ConnectionPool.INSTANCE.getAvailableConnections().size()==0){
            try {
                System.out.println("not available connections waiting...");
                Thread.sleep(5000);
                return this.findById(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try(Connection connection=ConnectionPool.INSTANCE.getAvailableConnection()) {
                StatementCreator<User,Integer> creator = new StatementCreator<>();
                return  creator.findById(User.class, connection,id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
        /*User user=null;
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

        return user;*/
    }


    @Override
    public User update(User user) {
        /*while (connection == null) {
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
        return user;*/
        return null;
    }

    @Override
    public void create(User user) {
        /*while (connection == null) {
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
        }*/

    }

    @Override
    public void delete(Integer id) {
        if(ConnectionPool.INSTANCE.getAvailableConnections().size()==0){
            try {
                System.out.println("not available connections waiting...");
                Thread.sleep(5000);
                delete(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try(Connection connection=ConnectionPool.INSTANCE.getAvailableConnection()) {
                StatementCreator<User,Integer> creator = new StatementCreator<>();
                creator.delete(User.class, connection,id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
