package com.parawan.authorisation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class GoogleLoginServlet extends HttpServlet {

    private static final String USER_NAME = "UserName";
    private static final String USER_EMAIL = "UserEmail";
    private static final String USER_LOGIN_TYPE = "UserLoginType";
    private static final String USER_IMG = "UserUrl";
    private static final String USER_TYPE = "userType";

    private static final Logger logger = LoggerFactory.getLogger(GoogleLoginServlet.class);

    @Inject
    private AdminService adminService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");

        if (ids == null || ids.length() == 0) {
            logger.info("id was not provided");
            resp.sendRedirect("/login");

        } else { resp.sendRedirect("/parawan/find-place");

        }
    }
}