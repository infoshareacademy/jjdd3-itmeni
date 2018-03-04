package com.parawan.servlets;

import com.parawan.dao.ReservationDao;
import com.parawan.model.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.util.List;

@WebServlet(urlPatterns = "/db")
public class DatabaseTests extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(DatabaseTests.class);

    @Inject
    private ReservationDao reservationDao;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // Test data


        Reservation reservation = new Reservation
                (null, 10, 69, "sut", "TestSubject1");
        reservationDao.save(reservation);


        LOG.info("System time zone is: {}", ZoneId.systemDefault());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        final String action = req.getParameter("action");
        LOG.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }

        if (action.equals("findAll")) {
            findAll(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }
    }


    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<Reservation> result;

        result = reservationDao.findAll();


        LOG.info("Found {} objects", result.size());
        for (Reservation s : result) {
            resp.getWriter().write(s.toString() + "\n");
        }
    }
}

