package uz.java.web.app.servlets;

import uz.java.web.app.dto.UserData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dilsh0d on 06.10.2017.
 */
public class Login extends javax.servlet.http.HttpServlet {
    private static Map<String,UserData> userDataMap;
    static {
        UserData userData1 = new UserData();
        userData1.setUsername("admin@admin.uz");
        userData1.setPassword("admin");
        userData1.setFirstname("Admin");
        userData1.setLastname("Adminov");

        UserData userData2 = new UserData();
        userData2.setUsername("user@user.uz");
        userData2.setPassword("user");
        userData2.setFirstname("User");
        userData2.setLastname("Userov");

        userDataMap = new HashMap<>();

        userDataMap.put(userData1.getUsername(),userData1);
        userDataMap.put(userData2.getUsername(),userData2);

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("login");
        String password = request.getParameter("password2");

        if(username == null || "".equals(username.trim())){
            request.getRequestDispatcher("/index.jsp").include(request,response);
        }

        if(password == null || "".equals(password.trim())){
            request.getRequestDispatcher("/index.jsp").include(request,response);
        }

        if(userDataMap.containsKey(username)){
            UserData currentUser = userDataMap.get(username);
            if(currentUser.getPassword().equals(password)){
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
