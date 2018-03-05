package com.parawan.servlets;

import com.parawan.Beach;
import com.parawan.ItemType;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;
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
import java.util.Map;

@WebServlet("/make-reservation")
public class MakeReservationServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MakeReservationServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Beach beach =new Beach("BrzeźnoBeach", 20, 10);
        int firstId = beach.getPlaces().get(0).getId();
        int lastId = beach.getPlaces().get(beach.getPlaces().size() - 1).getId();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("firstId", firstId);
        dataModel.put("lastId", lastId);

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

        try {
            reservation.setHourOfReservation(Integer.parseInt(req.getParameter("chosenHour")));
            reservation.setPlaceId(Integer.parseInt(req.getParameter("chosenId")));
        } catch (NumberFormatException e) {
            LOG.error("Error while making reservation", e);
            resp.sendRedirect("/error-servlet");
        }
        reservation.setNameOfPerson(req.getParameter("chosenName"));

        try {
            if (req.getParameter("chosenScreen").equals("s")) {
                reservation.putRentedItemOnList(ItemType.SCREEN);
            }
        } catch (NullPointerException e) {
            LOG.info("During reservation, screen was not chosen", e);
        }

        try {
            if (req.getParameter("chosenUmbrella").equals("u")) {
                reservation.putRentedItemOnList(ItemType.UMBRELLA);
            }
        } catch (NullPointerException e) {
            LOG.info("During reservation, umbrella was not chosen", e);
        }

        try {
            if (req.getParameter("chosenTowel").equals("t")) {
                reservation.putRentedItemOnList(ItemType.TOWEL);
            }
        } catch (NullPointerException e) {
            LOG.info("During reservation, towel was not chosen", e);
        }

        try {
            if (req.getParameter("chosenSunbed").equals("b")) {
                reservation.putRentedItemOnList(ItemType.SUNBED);
            }
        } catch (NullPointerException e) {
            LOG.info("During reservation, towel was not chosen", e);
        }

        ReservationTable reservationTable = new ReservationTable();
        reservationTable.add(reservation);
        resp.sendRedirect("/make-reservation");
    }
}