package com.parawan.servlets;

import com.parawan.freemarker.TemplateProvider;
import com.parawan.model.ActualBeach;
import com.parawan.weatherApi.JsonParser;
import com.parawan.weatherApi.ListOfWeatherComponents;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/parawan/weather-forecast")
public class WeatherForecastServlet extends HttpServlet {

    @Inject
    private ActualBeach actualBeach;

    @Inject
    private JsonParser jsonParser;

    private static final Logger LOG = LoggerFactory.getLogger(WeatherForecastServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ListOfWeatherComponents[] listOfWeatherComponents = jsonParser.getWeatherForecast().getList();
        List<String> weatherComponentsInList = new ArrayList<>();
        for(int i = 0; i<9; i=i+2){

            weatherComponentsInList.add(listOfWeatherComponents[i].getDtTxt());
            weatherComponentsInList.add(listOfWeatherComponents[i].getWeather()[0].toString());
            weatherComponentsInList.add(listOfWeatherComponents[i].getMain().toString());
            weatherComponentsInList.add("Pressure: "+listOfWeatherComponents[i].getMain().getPressure()+" hPa");
            weatherComponentsInList.add(listOfWeatherComponents[i].getWind().toString());
            weatherComponentsInList.add("");
        }

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("actualBeach", actualBeach);
        dataModel.put("bodytemplate", "weather-forecast");
        dataModel.put("weather", weatherComponentsInList);

        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }
    }
}