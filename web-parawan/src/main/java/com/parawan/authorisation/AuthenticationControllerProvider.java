package com.parawan.authorisation;

import com.auth0.AuthenticationController;

import javax.servlet.ServletConfig;
import java.io.UnsupportedEncodingException;

public abstract class AuthenticationControllerProvider {

    private static String domain;
    private static String clientId;
    private static String clientSecret;

    public static AuthenticationController getInstance(ServletConfig config) throws UnsupportedEncodingException {

         domain = config.getServletContext().getInitParameter("com.auth0.domain");
         clientId = config.getServletContext().getInitParameter("com.auth0.clientId");
         clientSecret = config.getServletContext().getInitParameter("com.auth0.clientSecret");

        return AuthenticationController.newBuilder(domain, clientId, clientSecret)
                .build();
    }

}
