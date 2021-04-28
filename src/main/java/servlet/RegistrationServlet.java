package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*RequestDispatcher view = req.getRequestDispatcher("src/main/resources/html/registration.html");
        view.forward(req,resp);*/
        Scanner scanner=new Scanner(new File("D://drug-store/src/main/resources/html/registration.html"));
        resp.setContentType("text/html");
        PrintWriter writer=resp.getWriter();

        while (scanner.hasNext()){
            writer.write(scanner.nextLine());
        }
        writer.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(login+" "+password);
        writer.close();
    }
}
