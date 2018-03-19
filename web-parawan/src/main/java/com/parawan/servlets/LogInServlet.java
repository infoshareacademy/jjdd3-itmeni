package com.parawan.servlets;

import com.parawan.dao.UserDao;
import com.parawan.model.User;
import com.parawan.model.UserSession;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/log-in")
public class LogInServlet extends HttpServlet {

    @Inject
    private UserSession userSession;

    @Inject
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String email = req.getParameter("email");
      String password = req.getParameter("password");
      attemptToLogIn(email, password);
    }

    protected boolean attemptToLogIn(String email, String password){
        User user = userDao.getUserToLogIn(email, password);
        if(user!=null){
            userSession.setName(user.getName());
            userSession.setEmail(user.getEmail());
            userSession.setAdmin(user.isAdmin());
            return true;
        }
        return false;
    }

}
