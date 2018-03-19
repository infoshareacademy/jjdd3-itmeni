package com.parawan.servlets.loginservlets;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.parawan.loginconfig.Configuration;
import com.parawan.loginconfig.ConfigurationLoader;
import com.parawan.authorisation.AdminService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("login")
public class FacebookLoginServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacebookLoginServlet.class);

    public static final String USER_NAME = "UserName";
    public static final String USER_EMAIL = "UserEmail";
    public static final String USER_LOGIN_TYPE = "UserLoginType";
    public static final String USER_TYPE = "userType";

    @Inject
    private AdminService adminService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ConfigurationLoader.loadConfiguration();
        Configuration config = ConfigurationLoader.getConfiguration();

        boolean isLocal = req.getServerName().equals("localhost");
        String facebookAppId = isLocal ? config.getTestFacebookAppId() : config.getFacebookAppId();
        String facebookAppSecret = isLocal ? config.getTestFacebookAppSecret() : config.getFacebookAppSecret();

        String logout = req.getParameter("logout");
        if ("1".equals(logout)) {
            String loginType = (String) req.getSession().getAttribute(USER_LOGIN_TYPE);
            req.getSession().removeAttribute(USER_NAME);
            req.getSession().removeAttribute(USER_EMAIL);
            req.getSession().removeAttribute(USER_LOGIN_TYPE);

            if ("fb".equals(loginType)) {
                req.setAttribute("facebookAppId", facebookAppId);
                req.getRequestDispatcher("logout.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("login");
            }
            return;
        }

        String userName = req.getParameter("user_name");
        String userEmail = req.getParameter("user_email");
        String accessToken = req.getParameter("access_token");
        String userId = req.getParameter("user_id");

        if (userName == null || userEmail == null) {

            req.setAttribute("facebookAppId", facebookAppId);
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        } else {
            String APP_SECRET = facebookAppSecret;
            try {
                HttpResponse<JsonNode> response = Unirest.get("https://graph.facebook.com/debug_token")
                        .queryString("input_token", accessToken)
                        .queryString("access_token", facebookAppId + "|" + APP_SECRET)
                        .asJson();

                LOGGER.info(response.getStatus() + response.getBody().toString());
                String uid = response.getBody().getObject().getJSONObject("data").getString("user_id");
                if (uid.equals(userId)) {
                    req.getSession().setAttribute(USER_NAME, userName);
                    req.getSession().setAttribute(USER_EMAIL, userEmail);
                    LOGGER.info("e-mail: " + userEmail);
                    req.getSession().setAttribute(USER_LOGIN_TYPE, "fb");
                    req.getSession().setAttribute(USER_TYPE, adminService.isAdmin(userEmail));
                    resp.sendRedirect("parawan/main-menu");
                    return;
                }
            } catch (UnirestException | JSONException e) {
                LOGGER.error("Could not confirm token. " + e.getMessage(), e);
                req.setAttribute("message", "Could not authenticate with FB. Please try again or use alternative log in.");
            } finally {
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
            }
        }
    }
}