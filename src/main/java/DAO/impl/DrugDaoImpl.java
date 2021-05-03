package DAO.impl;

import DAO.DrugDao;
import DAO.StatementCreator;
import model.Drug;
import service.ConnectionService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DrugDaoImpl implements DrugDao {
    StatementCreator<Drug,Integer> creator;

    public DrugDaoImpl() {
        this.creator = new StatementCreator<>();
    }

    @Override
    public List<Drug> findAll() {
        try(Connection connection= ConnectionService.getInstance().getConnection()) {
            return creator.findAll(Drug.class, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Drug findById(Integer id) {
        try(Connection connection=ConnectionService.getInstance().getConnection()) {
            return creator.findById(Drug.class, connection,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Drug update(Drug drug) {
        try(Connection connection=ConnectionService.getInstance().getConnection()) {
            return creator.update(drug, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Drug drug) {
        try(Connection connection=ConnectionService.getInstance().getConnection()) {
            creator.create(drug, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection connection=ConnectionService.getInstance().getConnection()) {
            creator.delete(Drug.class, connection, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
