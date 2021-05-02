package command.impl.post;

import application.ApplicationContext;
import command.Command;
import command.enums.Path;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class AuthorizationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ApplicationContext context=ApplicationContext.INSTANCE;
        //todo criteria for name
        List<User> users = context.getUserDao().findAll();
        try {
            User curUser=users.stream().filter(user -> login.equals(user.getLogin())).findFirst().get();
            if(!curUser.getPassword().equals(password)){
                request.setAttribute("message","Неверный пароль");
                request.getRequestDispatcher("/").forward(request, response);
            }
        }catch (NoSuchElementException exception){
            request.setAttribute("message","Неверный логин");
            request.getRequestDispatcher("/").forward(request, response);
        }






    }
}
