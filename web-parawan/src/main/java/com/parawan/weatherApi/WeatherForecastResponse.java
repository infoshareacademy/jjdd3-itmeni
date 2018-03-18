package com.parawan.weatherApi;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastResponse {

    @JsonProperty("list")
    private ListOfWeatherComponents[] list;

 /*   @JsonProperty("cod")
    private String cod;

    @JsonProperty("message")
    private String message;

    @JsonProperty("cnt")
    private String cnt;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }*/

    public ListOfWeatherComponents[] getList() {
        return list;
    }

    public void setList(ListOfWeatherComponents[] list) {
        this.list = list;
    }
}
