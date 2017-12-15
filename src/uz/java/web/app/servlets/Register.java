package uz.java.web.app.servlets;

import uz.java.web.app.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random random = new Random();
        int a = random.nextInt(20);
        int b = random.nextInt(20);
        String q = a+" + "+b+" = ?";
        req.setAttribute("question",q);
        req.getSession().setAttribute("correctAnswer",(a+b));

        req.getRequestDispatcher("/register.jsp").include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firtName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String answer = req.getParameter("answer");

        boolean isError = false;
        if(answer==null || "".equals(answer)){
            isError = true;
        }

        if(!answer.equals(req.getSession().getAttribute("correctAnswer").toString())){
            isError = true;
        }

        if(!isError) {
            UserDao userDao = new UserDao();
            if (!userDao.hasUsername(userName)) {
                userDao.createUser(userName,password1,firtName,lastName);
                resp.sendRedirect("/login");
            } else {
                antiBot(req,resp);
            }
        } else {
            antiBot(req,resp);
        }
    }

    public void antiBot(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random random = new Random();
        int a = random.nextInt(20);
        int b = random.nextInt(20);
        String q = a+" + "+b+" = ?";

        req.setAttribute("question",q);
        req.getSession().setAttribute("correctAnswer",(a+b));
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}
