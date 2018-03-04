package com.parawan.servlets;

import com.parawan.com.menu.CancelReservation;
import com.parawan.freemarker.TemplateProvider;
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


@WebServlet("/cancel-reservation")
public class CancelReservationServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());
    Template template;

    // @EJB

    @Override
    public void init() throws ServletException{
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "cancel-reservation.ftlh");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        CancelReservation cancelReservation =new CancelReservation();

        cancelReservation.setCancelId(Integer.parseInt(req.getParameter("cancelId")));
        cancelReservation.setCancelHour(Integer.parseInt(req.getParameter("cancelHour")));

        resp.sendRedirect("/main-menu");

    }
}
