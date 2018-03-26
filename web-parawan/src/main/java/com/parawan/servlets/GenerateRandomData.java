package com.parawan.servlets;

import com.parawan.dao.BeachDao;
import com.parawan.dao.ItemDao;
import com.parawan.dao.ReservationDao;
import com.parawan.dao.UserDao;
import com.parawan.model.Beach;
import com.parawan.model.Item;
import com.parawan.model.Reservation;
import com.parawan.model.User;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/generaterandomdata")
public class GenerateRandomData extends HttpServlet {

    @Inject
    private ReservationDao reservationDao;

    @Inject
    private BeachDao beachDao;

    @Inject
    private ItemDao itemDao;

    @Inject
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        if (beachDao.findAll() == null || beachDao.findAll().isEmpty()){
            fillDatabase(req, resp);
        }
        else resp.sendRedirect("/login");
    }

    private void fillDatabase(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Beach beach = new Beach(null, "Jelitkowo", 20, 10);
        beachDao.save(beach);
        Beach beach2 = new Beach(null, "Stogi", 10, 10);
        beachDao.save(beach2);
     
        for (int i = 0; i < 400; ) {
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
                    , new Random().nextInt(11) + 9
                    , new Random().nextInt(200) + 1
                    , itemsString
                    , nameString);
            reservation.setBeach(beach);
            if (!reservationDao.checkIfAlreadyReserved(reservation)) {
                reservationDao.save(reservation);
            }
            i++;
        }
        Item screen = new Item("screen", "s", 150, beach);
        Item umbrella = new Item("umbrella", "u", 150, beach);
        Item towel = new Item("towel", "t", 150, beach);
        Item sunbed = new Item("sunbed", "b", 150, beach);
        itemDao.save(screen);
        itemDao.save(umbrella);
        itemDao.save(towel);
        itemDao.save(sunbed);
        Item screen2 = new Item("screen", "s", 150, beach2);
        Item umbrella2 = new Item("umbrella", "u", 150, beach2);
        Item towel2 = new Item("towel", "t", 150, beach2);
        Item sunbed2 = new Item("sunbed", "b", 150, beach2);
        itemDao.save(screen2);
        itemDao.save(umbrella2);
        itemDao.save(towel2);
        itemDao.save(sunbed2);
        User pr0admin1 = new User("Krzysiek", "prezydium834@gmail.com");
        User pr0admin2 = new User("Bartek", "bartlomiej.korespondencja@gmail.com");
        User pr0user2 = new User("Szymon", "itmeni.parawantest@gmail.com");
        User pr0admin4 = new User("iSA", "isaloginjava@gmail.com");

        pr0admin1.setAdmin(true);
        pr0admin2.setAdmin(true);

        pr0admin4.setAdmin(true);
        User pr0user = new User("Qwerty", "password@o2.pl");
        userDao.save(pr0admin1);
        userDao.save(pr0admin2);
        userDao.save(pr0user2);
        userDao.save(pr0user);
        userDao.save(pr0admin4);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

