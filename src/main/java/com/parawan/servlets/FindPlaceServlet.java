package com.parawan.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-place")
public class FindPlaceServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter printWriter=resp.getWriter();

        printWriter.write("<!DOCTYPE html>");
        printWriter.write("<html>");
        printWriter.write("<body>");
        printWriter.write("<p>Find place with additional requirements</p>");
        printWriter.write("<p><a href=\"/main-menu\">Go back to main menu </a></p>");
        printWriter.write("</body>");
        printWriter.write("</html>");
    }
}
