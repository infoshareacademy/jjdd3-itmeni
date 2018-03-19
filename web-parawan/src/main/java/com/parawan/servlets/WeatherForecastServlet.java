package com.parawan.servlets;

import com.parawan.weatherApi.JsonParser;
import com.parawan.weatherApi.ListOfWeatherComponents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/weather-forecast")
public class WeatherForecastServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonParser jsonParser = new JsonParser();

        PrintWriter writer = resp.getWriter();


        ListOfWeatherComponents[] listOfWeatherComponents = jsonParser.getWeatherForecast().getList();

        for (int i = 0; i < 7; i++) {
            writer.println("\n");
            writer.println(listOfWeatherComponents[i].getDtTxt());
            writer.println(listOfWeatherComponents[i].getMain());
            writer.println(listOfWeatherComponents[i].getWeather()[0]);
            writer.println(listOfWeatherComponents[i].getWind());
        }
    }
}
