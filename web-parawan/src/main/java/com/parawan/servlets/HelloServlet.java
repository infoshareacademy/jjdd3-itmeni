package com.parawan.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

        printWriter.write("<!DOCTYPE html>");
        printWriter.write("<html>");
        printWriter.write("<body>");
        printWriter.write("<p>Private beach management system - PARAWAN</p>");
        printWriter.write("<p><a href=\"/main-menu\">Move on to main menu </a></p>");
        printWriter.write("</body>");
        printWriter.write("</html>");
    }
}
