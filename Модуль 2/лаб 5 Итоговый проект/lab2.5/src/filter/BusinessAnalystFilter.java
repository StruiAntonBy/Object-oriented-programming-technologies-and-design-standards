package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;

public class BusinessAnalystFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)req).getSession(false);
        User user=(User)session.getAttribute("user");
        if(user.getRole()==2) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse)resp).sendRedirect(
                ((HttpServletRequest)req).getContextPath()
                + "/index.html"
            );
        }
    }

    @Override
    public void destroy() {}
}
