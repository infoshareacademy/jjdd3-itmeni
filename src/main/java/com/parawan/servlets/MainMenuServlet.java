package com.parawan.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("main-menu")
public class MainMenuServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        PrintWriter printWriter=resp.getWriter();

        printWriter.write("<!DOCTYPE html>");
        printWriter.write("<html>");
        printWriter.write("<body>");
        printWriter.write("<p>Main Menu</p>");

        printWriter.write("<nav>");
        printWriter.write("<ul>");
        printWriter.write("<li>");
        printWriter.write("<a href=\"/make-reservation.html\">Make reservation </a>");
        printWriter.write("</li>");
        printWriter.write("<li>");
        printWriter.write("<a href=\"/cancel-reservation\">Cancel reservation </a>");
        printWriter.write("</li>");
        printWriter.write("<li>");
        printWriter.write("<a href=\"/find-place\">Find place with additional requirements </a>");
        printWriter.write("</li>");
        printWriter.write("<li>");
        printWriter.write("<a href=\"/item-management\">Number of items available for rent  </a>");
        printWriter.write("</li>");
        printWriter.write("</ul>");
        printWriter.write("</nav>");

        printWriter.write("<p><a href=\"/hello-servlet\">Go back to intro page </a></p>");
        printWriter.write("</body>");
        printWriter.write("</html>");
    }
}
