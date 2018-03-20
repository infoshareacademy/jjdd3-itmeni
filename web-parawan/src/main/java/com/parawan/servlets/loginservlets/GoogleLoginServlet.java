package com.parawan.servlets.loginservlets;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.parawan.authorisation.AdminService;
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

    private static final String USER_NAME = "UserName";
    private static final String USER_EMAIL = "UserEmail";
    private static final String USER_LOGIN_TYPE = "UserLoginType";
    private static final String USER_TYPE = "userType";
    private static final String USER_ID = "userId";

    @Inject
    private AdminService adminService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("user_id");

        Object ids = req.getParameterMap().get("user_id");
        if (ids == null) {
            logger.info("id was not provided");
            req.setAttribute("user_id", userId);
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
            return;
        } else {
            Object id = ids;
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
                    String userID = object.getString("userId");

                    logger.info("User e-mail: " + email);

                    req.getSession().setAttribute(USER_NAME, name);
                    req.getSession().setAttribute(USER_EMAIL, email);
                    req.getSession().setAttribute(USER_ID, userID);
                    req.getSession().setAttribute(USER_LOGIN_TYPE, "google");
                    req.getSession().setAttribute(USER_TYPE, adminService.isAdmin(email));

                    resp.sendRedirect("parawan/main-menu");
                }
            } catch (UnirestException e) {
                logger.error("Cannot validate google token", e);
                e.printStackTrace(resp.getWriter());
            }
        }
    }
}