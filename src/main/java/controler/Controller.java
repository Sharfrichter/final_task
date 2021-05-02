package controler;

import command.Command;
import command.enums.CommandInstance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*RequestDispatcher view = req.getRequestDispatcher("main_page.jsp");
        view.forward(req,resp);*/
        String commandName = req.getParameter("command");
        Command command = CommandInstance.commandOf(commandName);
        command.execute(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName=req.getParameter("command");
        Command command = CommandInstance.commandOf(commandName);
        command.execute(req,resp);
//        resp.setContentType("text/html");
//        PrintWriter writer = resp.getWriter();
//        writer.write(login+" "+password);
//        writer.close();
    }
}
