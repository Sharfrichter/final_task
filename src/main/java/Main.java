import ConnectionPool.ConnectionPool;
import DAO.UserDAO;
import Model.User;

public class Main {
    public static void main(String[] args) {

        ConnectionPool.INSTANCE.init(5);
        UserDAO userDAO = new UserDAO();
        User user = new User(2, "LOGIN", "PASSWORD", "Grisha", "Petrov", 1);
        User user1 = new User(5, "alex", "223231", "Alex", "Nevski", 1);
        //userDAO.create(user1);
        userDAO.update(user);


    }
}
