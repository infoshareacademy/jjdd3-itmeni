package com.parawan.servlets;

import com.parawan.ItemType;
import com.parawan.Place;
import com.parawan.PlaceStatus;
import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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

import org.slf4j.Logger;

@WebServlet("/parawan/find-place")
public class FindPlaceServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(FindPlaceServlet.class);

    @Inject
    private ActualBeach actualBeach;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> dataModel = new HashMap<>();

        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");
        dataModel.put("actualBeach", actualBeach);
        dataModel.put("bodytemplate", "find-place");


        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Place placeToAvoid = new Place();

        if (req.getParameter("noNeighbours").equals("y")) {
            placeToAvoid.setStatus(PlaceStatus.RESERVED);
        } else {
            placeToAvoid.setStatus(PlaceStatus.FREE);
        }

        if (req.getParameter("noScreens").equals("y")) {
            placeToAvoid.putItemToRentedItemsList(ItemType.SCREEN);
        }

        if (req.getParameter("noUmbrella").equals("y")) {
            placeToAvoid.putItemToRentedItemsList(ItemType.UMBRELLA);
        }
        resp.sendRedirect("/parawan/find-place");
    }
}