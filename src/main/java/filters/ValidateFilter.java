package filters;


import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/admin"})
public class ValidateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            resp.sendRedirect("/");
        }else if (user.getRole().equals("user")){
            resp.sendRedirect("/user");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
