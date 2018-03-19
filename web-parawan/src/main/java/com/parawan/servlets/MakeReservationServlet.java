package com.parawan.servlets;

import com.parawan.dao.ReservationDao;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import com.parawan.view.Place;
import com.parawan.view.ReservationPrinter;
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

    @Inject
    private ReservationDao reservationDao;

    @Inject
    private ReservationPrinter reservationPrinter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> dataModel = new HashMap<>();
        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");
        dataModel.put("actualBeach", actualBeach);
        dataModel.put("bodytemplate", "make-reservation");

        this.putErrorToDataModel(dataModel, req);
        this.putPlacesAndStatusToDataModel(dataModel, req);

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

    Map<String, Object> putErrorToDataModel(Map<String, Object> dataModel, HttpServletRequest req) {

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");

        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            req.getSession().removeAttribute("errors");
        }
        return dataModel;
    }

    Map<String, Object> putPlacesAndStatusToDataModel(Map<String, Object> dataModel, HttpServletRequest req) {
        if (req.getParameter("status") != null || req.getParameter("status").isEmpty()) {
            int hour = Integer.parseInt(req.getParameter("status"));
            List<Place> places = reservationPrinter.beachToPrint(hour);
            dataModel.put("places", places);
            dataModel.put("hour", hour);
        }
        return dataModel;
    }
}