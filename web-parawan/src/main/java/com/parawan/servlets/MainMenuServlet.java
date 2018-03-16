package com.parawan.servlets;

import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import com.parawan.servlets.loginservlets.HomeServlet;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/parawan/main-menu")
public class MainMenuServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MainMenuServlet.class);

    @Inject
    private ActualBeach actualBeach;

    @Inject
    private HomeServlet userId;

    @Inject
    private HomeServlet idToken;

    @Inject
    private HomeServlet accessToken;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> dataModel = new HashMap<>();

        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");
        dataModel.put("actualBeach", actualBeach);
        dataModel.put("bodytemplate", "main-menu");
        dataModel.put("userId", userId);
        dataModel.put("idToken", idToken);
        dataModel.put("accessToken", accessToken);

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }
}