package com.parawan.servlets;


import com.parawan.dao.ReservationDao;
import com.parawan.model.Reservation;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/parawan/reservationsfromgivenhour")
public class ReservationsFromGivenHourServlet extends HttpServlet {

    @Inject
    private ReservationDao reservationDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getReservations(req, resp);
    }

    private void getReservations(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Reservation> result;
        Integer hour = Integer.parseInt(req.getParameter("hour"));

        result = reservationDao.findByHour(hour);


        for (Reservation r : result) {
            resp.getWriter().write(r.toString() + "\n");
        }
    }
}
