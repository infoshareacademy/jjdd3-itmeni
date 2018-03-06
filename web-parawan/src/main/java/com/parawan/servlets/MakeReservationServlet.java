package com.parawan.servlets;

import com.parawan.dao.BeachDao;
import com.parawan.dao.ReservationDao;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.Beach;
import com.parawan.model.Reservation;
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

@WebServlet("/make-reservation")
public class MakeReservationServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MakeReservationServlet.class);

    @Inject
    ReservationDao reservationDao;

    @Inject
    BeachDao beachDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> dataModel = new HashMap<>();

        Template template = TemplateProvider.createTemplate(getServletContext(), "make-reservation.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Reservation reservation = new Reservation();
        StringBuilder sb = new StringBuilder("");
        reservation.setHourOfReservation(Integer.parseInt(req.getParameter("chosenHour")));
        reservation.setPlaceId(Integer.parseInt(req.getParameter("chosenId")));
        reservation.setNameOfPerson(req.getParameter("chosenName"));

        if (!(req.getParameter("chosenScreen").equals(null))) {
            sb.append("s");
        }
        if (!(req.getParameter("chosenUmbrella").equals(null))) {
            sb.append("u");
        }
        if (!(req.getParameter("chosenTowel").equals(null))) {
            sb.append("t");
        }
        if (!(req.getParameter("chosenSunbed").equals(null))) {
            sb.append("b");
        }
        reservation.setBeach(beachDao.findById(1));
        reservation.setRentedItems(sb.toString());
        reservationDao.save(reservation);
        resp.sendRedirect("/make-reservation");
    }
}
