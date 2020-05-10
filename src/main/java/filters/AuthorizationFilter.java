package filters;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user"})
public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UserService service = UserService.getInstance();
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        String login = null;
        String password = null;
        login = req.getParameter("login");
        password = req.getParameter("pass");
        String role = null;
        if (session.getAttribute("roleUser") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else if (login == null || password == null) {
            resp.sendRedirect("/");
        } else {
            User user = null;
            user = service.getUser(login, password);
            if (user == null) {
                resp.sendRedirect("/");
            } else {
                role = user.getRole();
                switch (role) {
                    case "user":
                        session.setAttribute("roleUser", role);
                        filterChain.doFilter(servletRequest, servletResponse);
                        break;
                    case "admin":
                        session.setAttribute("roleUser", role);
                        resp.sendRedirect("/admin");
                        break;
                    default:
                        resp.sendRedirect("/");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
