package com.parawan.servlets;

import com.parawan.Beach;
import com.parawan.dao.ReservationDao;
import com.parawan.freemarker.TemplateProvider;
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
import java.util.Map;

@WebServlet("/make-reservation-next")
public class MakeReservationNextServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MakeReservationNextServlet.class);


    @Inject
    private ReservationDao reservationDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Beach beach = new Beach("BrzeźnoBeach", 20, 10);
        int firstId = beach.getPlaces().get(0).getId();
        int lastId = beach.getPlaces().get(beach.getPlaces().size() - 1).getId();
        int hourFromLastStep = Integer.parseInt(req.getParameter("chosenHour"));

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("firstId", firstId);
        dataModel.put("lastId", lastId);
        dataModel.put("hourFromLastStep", hourFromLastStep);

        Template template = TemplateProvider.createTemplate(getServletContext(), "make-reservation-next.ftlh");

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

        try {
            reservation.setHourOfReservation(Integer.parseInt(req.getParameter("chosenHour")));
            reservation.setPlaceId(Integer.parseInt(req.getParameter("chosenId")));
        } catch (NumberFormatException e) {
            LOG.error("Error while making reservation", e);
            resp.sendRedirect("/error-servlet");
        }
        reservation.setNameOfPerson(req.getParameter("chosenName"));

        if (req.getParameter("chosenScreen").equals("s")) {
            sb.append("s");
            LOG.info("During reservation, screen was chosen");
        }
        if (req.getParameter("chosenUmbrella").equals("u")) {
            sb.append("u");
            LOG.info("During reservation, umbrella was chosen");
        }
        if (req.getParameter("chosenTowel").equals("t")) {
            sb.append("t");
            LOG.info("During reservation, towel was chosen");
        }
        if (req.getParameter("chosenSunbed").equals("b")) {
            sb.append("b");
            LOG.info("During reservation, Sunbed was chosen");
        }

        reservation.setRentedItems(sb.toString());
        reservationDao.save(reservation);
        resp.sendRedirect("/main-menu");
    }
}
