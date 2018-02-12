package com.parawan;

import com.parawan.com.menu.*;



public class App {
    public static void main(String[] args)  {

        Beach sunnyBeach = new Beach(20, 10);
        sunnyBeach.createPlaces();

        JavaToXML myXMLWriter = new JavaToXML();

        XMLToJava myXMLReader = new XMLToJava();
        Places places = myXMLReader.xmlToJava();
        sunnyBeach.setPlaces(places);

        MainMenu mainMenu = new MainMenu();
        mainMenu.seeMenu(sunnyBeach, myXMLWriter);
    }
}