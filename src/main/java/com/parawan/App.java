package com.parawan;

import com.parawan.XMLparser.JavaToXML;
import com.parawan.XMLparser.Places;
import com.parawan.XMLparser.XMLToJava;
import com.parawan.com.menu.*;

import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException {

        String path = "src/main/resources/booking_status.xml";
        if (args.length != 1) {
            System.out.println("Please provide input file.");
            System.exit(1);
        } else {
            path = args[0];
            System.out.println("INPUT FILE: " + path);
        }

        Beach sunnyBeach = new Beach(20, 10);
        sunnyBeach.createPlaces();

        JavaToXML myXMLWriter = new JavaToXML();

        XMLToJava myXMLReader = new XMLToJava();

        Places places = myXMLReader.xmlToJava(path);
        sunnyBeach.setPlaces(places);

        MainMenu mainMenu = new MainMenu();
        mainMenu.showMenu(sunnyBeach, myXMLWriter);
    }
}