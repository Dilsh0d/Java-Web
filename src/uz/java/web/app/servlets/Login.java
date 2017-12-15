package uz.java.web.app.servlets;

import org.mindrot.BCrypt;
import uz.java.web.app.dao.UserDao;
import uz.java.web.app.dto.UserData;

import java.io.IOException;

/**
 * Created by dilsh0d on 06.10.2017.
 */
public class Login extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("login");
        String password = request.getParameter("password2");

        if(username == null || "".equals(username.trim())){
            request.getRequestDispatcher("/index.jsp").include(request,response);
        }

        if(password == null || "".equals(password.trim())){
            request.getRequestDispatcher("/index.jsp").include(request,response);
        }
        UserDao userDao = new UserDao();
        if(userDao.hasUsername(username)){
            UserData currentUser = userDao.getUserByUsername(username);
            if(BCrypt.checkpw(password,currentUser.getPassword())){
                request.getSession().setAttribute("userData",currentUser);
                response.sendRedirect("/users");
            } else {
                request.getRequestDispatcher("/index.jsp").include(request,response);
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").include(request,response);
    }
}
