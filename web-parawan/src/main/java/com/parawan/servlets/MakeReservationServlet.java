package com.parawan.servlets;

import com.parawan.freemarker.TemplateProvider;

import com.parawan.model.ActualBeach;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/parawan/make-reservation")
public class MakeReservationServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MakeReservationServlet.class);

    @Inject
    private ActualBeach actualBeach;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> dataModel = new HashMap<>();

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");

        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            req.getSession().removeAttribute("error");
        }

        Template template = TemplateProvider.createTemplate(getServletContext(), "make-reservation.ftlh");
        dataModel.put("actualBeach", actualBeach);
        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("/parawan/make-reservation-next");
    }
}