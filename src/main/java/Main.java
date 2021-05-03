import application.ApplicationContext;
import model.Drug;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=ApplicationContext.INSTANCE;
        Drug drug = new Drug(1,"drug11", 15.9, false, 150, false);
        context.getDrugDao().update(drug);






        /*
        *//*UserDAO userDAO = new UserDAO();

        User user1 = new User(5, "alex", "223231", "Alex", "Nevski", 1);
        //userDAO.create(user1);
        userDAO.update(user);*//*
        UserDao userDao = new UserDaoImpl();

        StatementCreator<User, Integer> creator = new StatementCreator<>();
        creator.update(new User(2, "aaaa", "aaaaa", "aaaaa", "aaaaa", 1), ConnectionPool.INSTANCE.getAvailableConnection());*/
        //User user = new User("asdasd", "wqeqwfdq", "wwwww", "qwqeqrw", 1);


       /* UserDaoImpl userDAOImpl = (UserDaoImpl) new Object();
        ClassLoader loader = userDAOImpl.getClass().getClassLoader();
        Class[] interfaces = userDAOImpl.getClass().getInterfaces();
        EntityDao proxyUserDao = (EntityDao) Proxy.newProxyInstance(loader, interfaces, new DaoInvocationHandler<User>(User.class));
        proxyUserDao.findAll().forEach(System.out::println);*/

    }

    
}
