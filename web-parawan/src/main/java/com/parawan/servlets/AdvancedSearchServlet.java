package com.parawan.servlets;


import com.parawan.dao.BeachDao;
import com.parawan.dao.ReservationDao;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.logic.AdvancedSearch;
import com.parawan.model.ActualBeach;
import com.parawan.model.Reservation;
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
import java.util.Map;

@WebServlet("/parawan/advanced-search")
public class AdvancedSearchServlet extends HttpServlet {


    private static final Logger LOG = LoggerFactory.getLogger(MakeReservationServlet.class);

    @Inject
    private ActualBeach actualBeach;

    @Inject
    private ReservationDao reservationDao;

    @Inject
    private BeachDao beachDao;

    @Inject
    private AdvancedSearch advancedSearch;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> dataModel = new HashMap<>();
        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");

        dataModel.put("actualBeach", actualBeach);
        dataModel.put("bodytemplate", "advanced-search");
        if (req.getAttribute("listOfPlaces") != null){
            dataModel.put("listOfPlaces", req.getAttribute("listOfPlaces"));
        }
        if (req.getAttribute("chosenHour") != null){
            dataModel.put("chosenHour", req.getAttribute("chosenHour"));
        }

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        Reservation reservation = new Reservation();
        if (req.getParameter("chosenHour") != null) {
            reservation.setHourOfReservation(Integer.parseInt(req.getParameter("chosenHour")));
        }
        if (req.getParameter("screen") != null && req.getParameter("screen").equals("s")){
            sb.append("s");
        }
        if(req.getParameter("umbrella") != null && req.getParameter("umbrella").equals("u")){
            sb.append("u");
        }
        reservation.setBeach(beachDao.findById(actualBeach.getId()));
        reservation.setRentedItems(sb.toString());
        req.setAttribute("listOfPlaces", advancedSearch.doSearch(reservation));
        req.setAttribute("chosenHour", req.getParameter("chosenHour"));
        this.doGet(req, resp);
    }
}
