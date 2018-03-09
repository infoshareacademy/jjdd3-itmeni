package com.parawan.servlets;


import com.parawan.dao.BeachDao;
import com.parawan.dao.ReservationDao;
import com.parawan.model.Beach;
import com.parawan.model.Reservation;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/parawan/find-beach")
public class FindBeachServlet extends HttpServlet {

    @Inject
    private BeachDao beachDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getBeach(req, resp);
    }

    private void getBeach(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Reservation> result;
        Integer beachId = Integer.parseInt(req.getParameter("beachId"));

        resp.getWriter().write(beachDao.findById(beachId).toString() + "\n");
    }
}
