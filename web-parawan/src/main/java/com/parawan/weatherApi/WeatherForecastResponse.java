package com.parawan.weatherApi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastResponse {

    @JsonProperty("list")
    private ListOfWeatherComponents[] list;

    public ListOfWeatherComponents[] getList() {
        return list;
    }

    public void setList(ListOfWeatherComponents[] list) {
        this.list = list;
    }
}