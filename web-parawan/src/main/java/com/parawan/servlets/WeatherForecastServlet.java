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

    private static final Logger LOG = LoggerFactory.getLogger(WeatherForecastServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonParser jsonParser = new JsonParser();
        ListOfWeatherComponents[] listOfWeatherComponents = jsonParser.getWeatherForecast().getList();
        List<String> listDtTxT = new ArrayList<>();
        for(int i = 0; i<9; i++){
            listDtTxT.add(listOfWeatherComponents[i].getDtTxt());

        }

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("actualBeach", actualBeach);
        dataModel.put("bodytemplate", "weather-forecast");
        dataModel.put("weather", listOfWeatherComponents);

        Template template = TemplateProvider.createTemplate(getServletContext(), "basepage.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            LOG.error("Error while loading freemarker template", e);
        }

  /*      JsonParser jsonParser = new JsonParser();
 PrintWriter writer = resp.getWriter();
        ListOfWeatherComponents[] listOfWeatherComponents = jsonParser.getWeatherForecast().getList();

        for (int i = 0; i < 9; i++) {
            writer.println("\n");
            writer.println(listOfWeatherComponents[i].getDtTxt());
            writer.println(listOfWeatherComponents[i].getWeather()[0]);
            writer.println(listOfWeatherComponents[i].getMain());
            writer.println(listOfWeatherComponents[i].getWind());
        }*/
    }
}
