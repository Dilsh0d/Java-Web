package uz.java.web.app.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecurityFilter implements Filter{

    public static List<String> noneFilters;

    static {
        noneFilters = new ArrayList<>();
        noneFilters.add("/");
        noneFilters.add("/login");
        noneFilters.add("/register");
        noneFilters.add("/assets/js/bootstrap.min.js");
        noneFilters.add("/assets/js/jquery-3.2.1.min.js");
        noneFilters.add("/assets/css/bootstrap.min.css");
        noneFilters.add("/assets/css/singin.css");
        noneFilters.add("/assets/css/singup.css");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fch) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if(noneFilters.contains(request.getRequestURI())){
            fch.doFilter(req,resp);
        } else if(request.getSession().getAttribute("userData")!=null){
            fch.doFilter(req,resp);
        } else {
            response.sendRedirect("/login");
        }

    }

    @Override
    public void destroy() {

    }
}
