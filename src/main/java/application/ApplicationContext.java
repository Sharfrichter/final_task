package application;

import ConnectionPool.ConnectionPool;
import DAO.UserDao;
import DAO.impl.UserDaoImpl;

public enum  ApplicationContext {
    INSTANCE;
    UserDao userDao;

    ApplicationContext() {
        this.userDao = new UserDaoImpl();
        ConnectionPool.INSTANCE.init(5);
    }

    public UserDao getUserDao() {
        return userDao;
    }


}
