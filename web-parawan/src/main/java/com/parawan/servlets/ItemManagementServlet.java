package com.parawan.servlets;

import com.parawan.com.menu.ItemManagement;
import com.parawan.datamanager.ReadReservationsFromFile;
import com.parawan.freemarker.TemplateProvider;
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



@WebServlet("/item-management")
public class ItemManagementServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CancelReservationServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int s = Integer.parseInt(req.getParameter("hourFromForm"));

        ReservationTable reservationTable = new ReservationTable();
        ItemManagement itemManagement = new ItemManagement();
        itemManagement.setTypedHour(Integer.parseInt(req.getParameter("hourFromForm")));

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("items", itemManagement.forRentAtGivenHour(reservationTable));
        dataModel.put("hour", s);

        Template template = TemplateProvider.createTemplate(getServletContext(), "item-management.ftlh");

        PrintWriter printWriter = resp.getWriter();

        try {
            template.process(dataModel, printWriter);

        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }
}
