package com.parawan.servlets;

import com.parawan.dao.ReservationDao;
import com.parawan.model.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/generaterandomdata")
public class GenerateRandomData extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(GenerateRandomData.class);

    @Inject
    private ReservationDao singleReservationDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

            fillDatabase(req, resp);


    }

    public void fillDatabase(HttpServletRequest req, HttpServletResponse resp) {


        for (int i = 0; i < 1000; i++) {
            String itemsString = "";
            String nameString = "Tester" + new Random().nextInt(10000);
            int randomItems = new Random().nextInt(5);

            switch (randomItems) {
                case 0:
                    itemsString = "ut";
                    break;
                case 1:
                    itemsString = "t";
                    break;
                case 2:
                    itemsString = "sutb";
                    break;
                case 3:
                    itemsString = "sb";
                    break;
                case 4:
                    itemsString = "";
                    break;
            }
            Reservation reservation = new Reservation(null
                    , new Random().nextInt(20)
                    , new Random().nextInt(100)
                    , itemsString
                    , nameString);
            singleReservationDao.save(reservation);
        }
    }
}

