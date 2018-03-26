package com.parawan.weatherApi;

import javax.ejb.Stateful;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateful
public class JsonParser {

    public WeatherForecastResponse getWeatherForecast() {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.openweathermap.org/data/2.5/forecast?APPID=911ddd6b9e551144f9e93318230dd105&id=7531890&lang=en&units=metric&mode=json");
        Response response = target.request().accept(MediaType.APPLICATION_JSON_TYPE).get();
        WeatherForecastResponse value = response.readEntity(WeatherForecastResponse.class);
        response.close();

        return value;
    }
}