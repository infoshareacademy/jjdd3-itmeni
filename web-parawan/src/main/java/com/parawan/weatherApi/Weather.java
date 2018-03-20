package com.parawan.weatherApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("description")
    String description;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append("Description: ").append(description);
        return sb.toString();
    }
}