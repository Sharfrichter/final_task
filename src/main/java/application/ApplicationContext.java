package application;

import DAO.ConnectionPool;
import DAO.DrugDao;
import DAO.UserDao;
import DAO.impl.DrugDaoImpl;
import DAO.impl.UserDaoImpl;

public enum  ApplicationContext {
    INSTANCE;
    UserDao userDao;
    DrugDao drugDao;

    ApplicationContext() {
        this.userDao = new UserDaoImpl();
        this.drugDao = new DrugDaoImpl();
        ConnectionPool.INSTANCE.init(5);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DrugDao getDrugDao() {
        return drugDao;
    }
}
