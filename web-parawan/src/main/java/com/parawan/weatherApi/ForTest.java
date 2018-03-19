package com.parawan.weatherApi;

public class ForTest {

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