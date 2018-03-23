package com.parawan.servlets;


import com.parawan.dao.BeachDao;
import com.parawan.dao.ReservationDao;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import com.parawan.model.Reservation;
import com.parawan.model.UserSession;
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


@WebServlet("/parawan/cancel-reservation")
public class CancelReservationServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CancelReservationServlet.class);

    @Inject
    private ActualBeach actualBeach;

    @Inject
    private ReservationDao reservationDao;

    @Inject
    private BeachDao beachDao;

    @Inject
    private UserSession userSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int firstId = 1;
        int lastId = (actualBeach.getMaxWidth()) * (actualBeach.getMaxHeight());
        List<Reservation> reservations = reservationDao.findByName(userSession.getEmail());
        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("reservations", reservations);
        dataModel.put("actualBeach", actualBeach);
        dataModel.put("bodytemplate", "cancel-reservation");
        dataModel.put("firstId", firstId);
        dataModel.put("lastId", lastId);

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

        int cancelationHour = Integer.parseInt(req.getParameter("cancelHour"));
        int cancelationId = Integer.parseInt(req.getParameter("cancelId"));

        reservationDao.deleteByHourAndId(cancelationHour, cancelationId, beachDao.findById(actualBeach.getId()));

        resp.sendRedirect("/parawan/cancel-reservation");
    }
}
