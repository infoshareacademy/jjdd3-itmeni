package com.parawan.weatherApi;

import java.util.Arrays;
import java.util.List;

public class odpalanie {

    public static void main(String[] args) {


        JsonParser jsonParser = new JsonParser();

        ListOfWeatherComponents[] listOfWeatherComponents = jsonParser.getWeatherForecast().getList();

        for (int i = 0; i < 7; i++) {
            System.out.println("\n");
            System.out.println(listOfWeatherComponents[i].getDtTxt());
            System.out.println(listOfWeatherComponents[i].getMain());
            System.out.println(listOfWeatherComponents[i].getWeather()[0]);
            System.out.println(listOfWeatherComponents[i].getWind());
        }
    }
}


