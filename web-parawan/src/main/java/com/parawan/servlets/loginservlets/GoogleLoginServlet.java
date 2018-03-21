package com.parawan.servlets.loginservlets;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.parawan.authorisation.AdminService;

import com.parawan.dao.UserDao;
import com.parawan.model.User;
import com.parawan.model.UserSession;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("login")
public class GoogleLoginServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(GoogleLoginServlet.class);

    @Inject
    private UserSession userSession;

    @Inject
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String ids = req.getParameter("id_token");

        String id = ids;
        try {
            HttpResponse<JsonNode> id_token = Unirest.get("https://www.googleapis.com/oauth2/v3/tokeninfo")
                    .queryString("id_token", id)
                    .asJson();

            if (id_token.getStatus() >= 300) {
                resp.getWriter().write("Invalid token, returned status was " + id_token.getStatus());
            } else {
                JSONObject object = id_token.getBody().getObject();
                String name = object.getString("name");
                String email = object.getString("email");

                logger.info("Username: " + name);
                logger.info("User e-mail: " + email);

                resp.sendRedirect("/hello-servlet");
            }


        } catch (UnirestException e) {
            logger.error("Cannot validate google token", e);
            e.printStackTrace(resp.getWriter());
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }

    protected boolean attemptToLogIn(String email, String name) {
        User user = userDao.getUserToLogIn(email, name);
        if (user != null) {
            userSession.setName(user.getName());
            userSession.setEmail(user.getEmail());
            userSession.setAdmin(user.isAdmin());
            return true;
        }
        return false;
    }
}