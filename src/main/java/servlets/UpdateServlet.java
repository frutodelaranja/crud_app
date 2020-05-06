package servlets;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    UserService service= UserService.getInstance();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserService service= UserService.getInstance();
        User user = new User();
        Long id = Long.valueOf(req.getParameter("id"));
        user = service.getUser(id);
        req.setAttribute("id", id);
        req.setAttribute("role", user.getRole());
        req.setAttribute("name", user.getName());
        req.setAttribute("mail", user.getLogin());
        req.setAttribute("pass", user.getPassword());
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserService service= UserService.getInstance();
        User user = new User();
        user.setId(Long.valueOf(req.getParameter("id")));
        user.setRole(req.getParameter("role"));
        user.setName(req.getParameter("name"));
        user.setLogin(req.getParameter("mail"));
        user.setPassword(req.getParameter("pass"));
        if (validate(user)){
            if (service.updateUser(user)){
                req.getRequestDispatcher("/").forward(req,resp);
            }else {
                doGet(req, resp);
            }
        }else {
            doGet(req, resp);
        }


    }

    private boolean validate(User user){
        boolean name = (!user.getName().equals("") && !user.getName().equals(" ") && !user.getName().equals("0") && user.getName() != null);
        boolean login = (!user.getLogin().equals("") && !user.getLogin().equals(" ") && !user.getLogin().equals("0") && user.getLogin() != null);
        boolean password = (!user.getPassword().equals("") && !user.getPassword().equals(" ") && !user.getPassword().equals("0") && user.getPassword() != null);
        return (name && login && password);
    }
}
