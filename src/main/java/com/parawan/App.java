package com.parawan;

import com.parawan.com.menu.*;


public class App {
    public static void main(String[] args) {
        String path = "src/test/resources/booking_status.xml";
        if (args.length != 1) {
            System.out.println("Please provide input file.");
            System.exit(1);
        } else {
            path = args[0];
            System.out.println("INPUT FILE: " + path);
        }
        String firstCommandLineArgument = args[0];


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