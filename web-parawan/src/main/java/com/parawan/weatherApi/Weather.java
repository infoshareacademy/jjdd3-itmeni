package com.parawan.weatherApi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {


    @JsonProperty("description")
    String description;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Weather{");
        sb.append("description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
