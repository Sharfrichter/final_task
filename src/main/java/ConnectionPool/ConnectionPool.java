package ConnectionPool;

import proxy.ConnectionProxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum ConnectionPool {
    INSTANCE;
    //todo in properties
    private static final String url = "jdbc:mysql://localhost:3306/jwd?serverTimezone=Europe/Moscow"; //change for reading from properties
    private static final String username = "root";
    private static final String password = "root";

    private final List<Connection> availableConnections;
    private List<Connection> notAvailableConnections;
   // boolean isAvailable=true;

    ConnectionPool() {
        this.availableConnections = new ArrayList<Connection>();
        this.notAvailableConnections = new ArrayList<Connection>();
    }


    public void init(int connectionsCount){
        for (int i = 0; i < connectionsCount; i++) {
            try(ConnectionProxy connection=new ConnectionProxy(DriverManager.getConnection(url,username,password))) {
            } catch (SQLException throwables) {
                //todo logger
                throwables.printStackTrace();
            }
        }
    }

    public void close(Connection connection){
        this.notAvailableConnections.remove(connection);
        this.availableConnections.add(connection);
        System.out.println("Connection has been returned to pool");
    }

    public List<Connection> getAvailableConnections(){
        return availableConnections;
    }

    public Connection getAvailableConnection(){
        if(this.availableConnections.size()==0){
            return null;
        }else {
            Connection connection=availableConnections.get(0);
            notAvailableConnections.add(connection);
            availableConnections.remove(connection);
            System.out.println("Connection has been allocated");
            return connection;
        }


    }



}
