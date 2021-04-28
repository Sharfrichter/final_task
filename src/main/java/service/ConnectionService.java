package service;

import ConnectionPool.ConnectionPool;

import java.sql.Connection;

public class ConnectionService {
    private static ConnectionService instance = new ConnectionService();

    private ConnectionService() {
    }

    public Connection getConnection(){
        if(ConnectionPool.INSTANCE.getAvailableConnections().size()==0){
            try {
                System.out.println("not available connections waiting...");
                Thread.sleep(5000);
                return this.getConnection();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            return ConnectionPool.INSTANCE.getAvailableConnection();
        }
        return null;
    }

    public static ConnectionService getInstance() {
        return instance;
    }
}
