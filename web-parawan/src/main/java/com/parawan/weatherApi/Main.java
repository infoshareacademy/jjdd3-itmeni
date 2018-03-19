package com.parawan.weatherApi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    @JsonProperty("temp")
    String temp;

    @JsonProperty("pressure")
    String pressure;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Main{");
        sb.append("temp='").append(temp).append('\'');
        sb.append(", pressure='").append(pressure).append('\'');
        sb.append('}');
        return sb.toString();
    }
}