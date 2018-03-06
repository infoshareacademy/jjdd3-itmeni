package com.parawan.servlets;

import com.parawan.dao.BeachDao;
import com.parawan.dao.ReservationDao;
import com.parawan.freemarker.TemplateProvider;

import com.parawan.model.Beach;
import com.parawan.model.Reservation;
import com.parawan.model.ActualBeach;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
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

@WebServlet("/make-reservation")
public class MakeReservationServlet extends HttpServlet {


    private static final Logger LOG = LoggerFactory.getLogger(MakeReservationServlet.class);


    @Inject
    private ReservationDao reservationDao;

    @Inject
    private ActualBeach actualBeach;

    @Inject
    private BeachDao beachDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int firstId = 0;
        int lastId = actualBeach.getMaxWidth()* actualBeach.getMaxHeight();

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
        StringBuilder sb = new StringBuilder("");

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
                sb.append("s");
            }
        } catch (NullPointerException e) {
            LOG.info("During reservation, screen was not chosen", e);
        }

        try {
            if (req.getParameter("chosenUmbrella").equals("u")) {
                sb.append("u");
            }
        } catch (NullPointerException e) {
            LOG.info("During reservation, umbrella was not chosen", e);
        }

        try {
            if (req.getParameter("chosenTowel").equals("t")) {
                sb.append("t");
            }
        } catch (NullPointerException e) {
            LOG.info("During reservation, towel was not chosen", e);
        }

        try {
            if (req.getParameter("chosenSunbed").equals("b")) {
                sb.append("b");
            }
        } catch (NullPointerException e) {
            LOG.info("During reservation, towel was not chosen", e);
        }
        reservation.setRentedItems(sb.toString());
        Integer a = actualBeach.getId();
        Beach beach = beachDao.findById(a);
        reservation.setBeach(beach);
        reservationDao.save(reservation);
        resp.sendRedirect("/make-reservation");
    }
}