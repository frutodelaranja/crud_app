package servlets;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = UserService.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("pass");
        User user = service.getUser(login, password);
        req.setAttribute("id", user.getId());
        req.setAttribute("role", user.getRole());
        req.setAttribute("name", user.getName());
        req.setAttribute("login", user.getLogin());
        req.setAttribute("pass", user.getPassword());

        req.getRequestDispatcher("/user.jsp").forward(req,resp);
    }
}
