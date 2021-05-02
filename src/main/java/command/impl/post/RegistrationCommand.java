package command.impl.post;

import application.ApplicationContext;
import command.Command;
import command.enums.Path;
import model.Role;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Role role = Role.USER;
        ApplicationContext context=ApplicationContext.INSTANCE;
        List<User> users = context.getUserDao().findAll();
        if (users.stream().anyMatch(user -> user.getLogin().equals(login))) {
            request.setAttribute("message", "Логин занят");
            request.getRequestDispatcher(Path.REGISTRATION_PAGE.getPath()).forward(request,response);
        }else {
            User user = new User(login, password, firstName, lastName, role.getId());
            ApplicationContext.INSTANCE.getUserDao().create(user);
            request.getRequestDispatcher("/").forward(request,response);
        }
    }
}
