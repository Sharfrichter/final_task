import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum ConnectionPool {
    INSTANCE;
    //todo
    private String url = "jdbc:mysql://localhost:3306/network?serverTimezone=Europe/Moscow"; //change for reading from properties
    private String username = "root";
    private String password = "root";
    private List<Connection> avaibleConnections;
    private List<Connection> notAvaibleConnections;

    ConnectionPool() {
        this.avaibleConnections = new ArrayList<Connection>();
        this.notAvaibleConnections = new ArrayList<Connection>();
    }

    public void init(){
        for (int i = 0; i < 10; i++) {
            try(ConnectionProxy connection=new ConnectionProxy(DriverManager.getConnection(url,username,password))) {
            } catch (SQLException throwables) {
                //todo
                throwables.printStackTrace();
            }
        }
    }

    public void close(Connection connection){
        this.notAvaibleConnections.remove(connection);
        this.avaibleConnections.add(connection);
    }

    public List<Connection> getAvaibleConnections(){
        return avaibleConnections;
    }


}
