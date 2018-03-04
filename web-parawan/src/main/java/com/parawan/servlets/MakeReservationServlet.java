package com.parawan.servlets;

import com.parawan.ItemType;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/make-reservation")
public class MakeReservationServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> dataModel = new HashMap<>();

        Template template = TemplateProvider.createTemplate(getServletContext(), "make-reservation.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Reservation reservation =new Reservation();

        reservation.setHourOfReservation(Integer.parseInt(req.getParameter("chosenHour")));
        reservation.setPlaceId(Integer.parseInt(req.getParameter("chosenId")));
        reservation.setNameOfPerson(req.getParameter("chosenName"));

        if(!(req.getParameter("chosenScreen").equals(null))){
            reservation.putRentedItemOnList(ItemType.SCREEN);
        }
        if(!(req.getParameter("chosenUmbrella").equals(null))){
            reservation.putRentedItemOnList(ItemType.UMBRELLA);
        }
        if(!(req.getParameter("chosenTowel").equals(null))){
            reservation.putRentedItemOnList(ItemType.TOWEL);
        }
        if(!(req.getParameter("chosenSunbed").equals(null))){
            reservation.putRentedItemOnList(ItemType.SUNBED);
        }
        ReservationTable reservationTable = new ReservationTable();
        reservationTable.add(reservation);
        resp.sendRedirect("/make-reservation");
    }
}
