package com.parawan.servlets;

import com.parawan.dao.BeachDao;
import com.parawan.dao.ReservationDao;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import com.parawan.model.Beach;
import com.parawan.model.Reservation;
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

@WebServlet("/parawan/make-reservation-next")
public class MakeReservationNextServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MakeReservationNextServlet.class);

    @Inject
    private ReservationDao reservationDao;

    @Inject
    private BeachDao beachDao;

    @Inject
    private ActualBeach actualBeach;

    @Inject
    private ReservationPrinter reservationPrinter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int firstId = 1;
        int lastId = (actualBeach.getMaxWidth()) * (actualBeach.getMaxHeight());

        int hourFromLastStep = Integer.parseInt(req.getParameter("chosenHour"));
        int idFromLastStep = Integer.parseInt(req.getParameter("chosenId"));

        Map<String, Object> dataModel = new HashMap<>();

        List<Place> places = reservationPrinter.beachToPrint(hourFromLastStep);
        dataModel.put("places", places);
        dataModel.put("hour", hourFromLastStep);

        if (req.getAttribute("isAlreadyReserved") != null) {
            dataModel.put("isAlreadyReserved", true);
            req.getSession().removeAttribute("isAlreadyReserved");
        }
        if (req.getAttribute("isReserved") != null) {
            dataModel.put("isReserved", true);
            req.getSession().removeAttribute("isReserved");
        }
        dataModel.put("actualBeach", actualBeach);
        dataModel.put("firstId", firstId);
        dataModel.put("lastId", lastId);
        dataModel.put("hourFromLastStep", hourFromLastStep);
        dataModel.put("idFromLastStep", idFromLastStep);
        dataModel.put("bodytemplate", "make-reservation-next");

        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");

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
        Beach beach = beachDao.findById(actualBeach.getId());
        reservation.setBeach(beach);
        if (!reservationDao.checkIfAlreadyReserved(reservation)) {
            reservationDao.save(reservation);
            req.setAttribute("isReserved", true);
            this.doGet(req, resp);

        } else {
            req.setAttribute("isAlreadyReserved", true);
            this.doGet(req, resp);
        }
    }
}
