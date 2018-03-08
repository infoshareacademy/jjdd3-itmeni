package com.parawan.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/parawan/set-beach")
public class SetBeachServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer choosenBeach = Integer.valueOf(req.getParameter("beach"));

        req.getSession().setAttribute("beach_id", choosenBeach);

        resp.sendRedirect("/parawan/main-menu");

    }
}
