package com.parawan;

import com.parawan.XMLparser.JavaToXML;
import com.parawan.XMLparser.Places;
import com.parawan.XMLparser.XMLToJava;
import com.parawan.com.menu.*;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        
        Beach sunnyBeach = new Beach(20, 10);
        sunnyBeach.createPlaces();

        JavaToXML myXMLWriter = new JavaToXML();

        XMLToJava myXMLReader = new XMLToJava();
        Places places = myXMLReader.xmlToJava("");
        sunnyBeach.setPlaces(places);

        MainMenu mainMenu = new MainMenu();
        mainMenu.showMenu(sunnyBeach, myXMLWriter);
    }
}