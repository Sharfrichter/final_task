package DAO.impl;

import ConnectionPool.ConnectionPool;
import DAO.EntityDao;
import DAO.UserDao;
import model.User;
import proxy.ConnectionProxy;
import service.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    StatementCreator<User,Integer> creator;

    public UserDaoImpl() {
        this.creator = new StatementCreator<>();
    }

    @Override
    public List<User> findAll() {
        try(Connection connection=ConnectionService.getInstance().getConnection()) {
            return creator.findAll(User.class, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        try(Connection connection=ConnectionService.getInstance().getConnection()) {
            return creator.findById(User.class, connection,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public User update(User user) {
        try(Connection connection=ConnectionService.getInstance().getConnection()) {
            return creator.update(user, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(User user) {
        try(Connection connection=ConnectionService.getInstance().getConnection()) {
            creator.create(user, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection connection=ConnectionService.getInstance().getConnection()) {
            creator.delete(User.class, connection, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
