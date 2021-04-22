package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class managerfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        Object username = req.getSession().getAttribute("username");
        if(username!=null)
        {
            chain.doFilter(request,response);
        }
        else {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
