package com.parawan.servlets;

import com.parawan.com.menu.CancelReservation;
import com.parawan.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


@WebServlet("/parawan/cancel-reservation")
public class CancelReservationServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CancelReservationServlet.class);
    Template template;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = TemplateProvider.createTemplate(getServletContext(), "cancel-reservation.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");
        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            dataModel.put("cancelReservation", req.getSession().getAttribute("cancelReservation"));
            req.getSession().removeAttribute("error");
            req.getSession().removeAttribute("cancelReservation");
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CancelReservation cancelReservation = new CancelReservation();

//        try {
            cancelReservation.setCancelId(Integer.parseInt(req.getParameter("cancelId")));
            cancelReservation.setCancelHour(Integer.parseInt(req.getParameter("cancelHour")));
//        } catch (NumberFormatException e) {
//            LOG.error("Error while making reservation", e);
//            resp.sendRedirect("/error-servlet");
//        }
        resp.sendRedirect("/main-menu");
    }
}
