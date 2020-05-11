package filters;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin"})
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
        User user = (User) session.getAttribute("user");
        login = req.getParameter("login");
        password = req.getParameter("pass");
        if (user == null){
            user = service.getUser(login, password);
            if (user == null) {
                resp.sendRedirect("/");
            }else {
                session.setAttribute("user", user);
                if (user.getRole().equals("admin")) {
                    resp.sendRedirect("/admin");
                }else {
                    resp.sendRedirect("/user");
                }
            }
        }else {
            if (user.getRole().equals("admin")){
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                resp.sendRedirect("/user");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
