package com.parawan.servlets;

import com.parawan.com.menu.ItemManagement;
import com.parawan.dao.ReservationDao;
import com.parawan.datamanager.ReadReservationsFromFile;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import com.parawan.model.Reservation;
import com.parawan.reservation.ReservationTable;
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


@WebServlet("/parawan/item-management")
public class ItemManagementServlet extends HttpServlet {

    @Inject
    private ReservationDao reservationDao;

    @Inject
    private ActualBeach actualBeach;

    private static final Logger LOG = LoggerFactory.getLogger(ItemManagementServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int hour = Integer.parseInt(req.getParameter("hourFromForm"));

        Map<String, Object> dataModel = new HashMap<>();
        List<String> errors = (List<String>) req.getSession().getAttribute("errors");

        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            req.getSession().removeAttribute("errors");
        }
        dataModel.put("hour", hour);
        dataModel.put("items", numberOfItemsStillToRent(req, resp));

        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");
        dataModel.put("bodytemplate", "item-management");
        dataModel.put("actualBeach", actualBeach);

        PrintWriter printWriter = resp.getWriter();

        try {
            template.process(dataModel, printWriter);

        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }

     int [] numberOfItemsStillToRent(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int amountOfScreen = 200;
        int amountOfUmbrella = 200;
        int amountOfTowel = 200;
        int amountOfSunbed = 200;

        int rentedAmountOfScreen = 0;
        int rentedAmountOfUmbrella = 0;
        int rentedAmountOfTowel = 0;
        int rentedAmountOfSunbed = 0;

        Integer hour = Integer.parseInt(req.getParameter("hourFromForm"));

        List<Reservation> itemList = reservationDao.findByHour(hour);
        for (Reservation reservation : itemList) {
            if (reservation.getRentedItems().contains("s")) {
                rentedAmountOfScreen++;
            }
            if (reservation.getRentedItems().contains("u")) {
                rentedAmountOfUmbrella++;
            }
            if (reservation.getRentedItems().contains("t")) {
                rentedAmountOfTowel++;
            }
            if (reservation.getRentedItems().contains("b")) {
                rentedAmountOfSunbed++;
            }
        }
        int stillToRentScreen = amountOfScreen - rentedAmountOfScreen;
        int stillToRentUmbrella = amountOfUmbrella - rentedAmountOfUmbrella;
        int stillToRentTowel = amountOfTowel - rentedAmountOfTowel;
        int stillToRentSunbed = amountOfSunbed - rentedAmountOfSunbed;

        int[] forRent = {stillToRentScreen, stillToRentUmbrella, stillToRentTowel, stillToRentSunbed};

        return forRent;
    }
}
