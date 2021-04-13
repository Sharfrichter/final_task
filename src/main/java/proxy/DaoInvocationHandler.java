package proxy;

import ConnectionPool.ConnectionPool;
import DAO.impl.StatementCreator;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DaoInvocationHandler<T,I> implements InvocationHandler {
    private Class<T> clazz;

    public DaoInvocationHandler(Class<T>t) {
        this.clazz = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StatementCreator<T,I> creator = new StatementCreator();
        return creator.findAll(this.clazz, ConnectionPool.INSTANCE.getAvailableConnection());
    }
}
