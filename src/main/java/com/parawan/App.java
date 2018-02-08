package com.parawan;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        Beach sunnyBeach = new Beach(20, 10);
        sunnyBeach.createPlaces();

        JavaToXML myXMLWriter = new JavaToXML();

        XMLToJava myXMLReader = new XMLToJava();
        Places places = myXMLReader.xmlToJava();
        sunnyBeach.setPlaces(places);

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.println("\nPrivate beach management system - PARAWAN. ||     date/hour: " + dateFormat.format(date));
            System.out.println("Please specify Your action.                ||               ver 1.0 ");
            System.out.println("\nWould You like to: [r]eserve place, [c]ancel reservation, [s]ee current beach preview, \nc[h]eck storehouse status, [q]uit program");

            String answer = scanner.nextLine();

            if (answer.equals("r")) {

                Reservation reservation=new Reservation();
                reservation.makeReservation(sunnyBeach, scanner);

            } else if (answer.equals("c")) {

                CancelReservation cancelReservation= new CancelReservation();
                cancelReservation.undoReservation(sunnyBeach, scanner);

            } else if (answer.equals("s")) {
                SeePlaces seePlaces=new SeePlaces();
                seePlaces.seeEverything(sunnyBeach);
            } else if (answer.equals("q")) {
                flag = false;
                //myXMLWriter.savePlacesToXML(sunnyBeach.getPlaces());
                System.out.println("Thank you for using PARAWAN - your private beach management system");
            }
        }
    }
}