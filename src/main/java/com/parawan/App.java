package com.parawan;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws FileNotFoundException, JAXBException {

        JavaToXML myXML = new JavaToXML();
        myXML.javaToXML();


        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        Beach sunnyBeach = new Beach(20, 10);
        sunnyBeach.createPlaces();


        Scanner scanner = new Scanner(System.in);
        boolean flag = true;


        while (flag) {

            System.out.println("\nPrivate beach management system - PARAWAN. ||     date/hour: " + dateFormat.format(date));
            System.out.println("Please specify Your action.                ||               ver 1.0 ");
            System.out.println("\nWould You like to: [r]eserve place, [c]ancel reservation, [s]ee current beach preview, \nc[h]eck storehouse status, [q]uit program");

            String answer = scanner.nextLine();

            if (answer.equals("r")) {
                System.out.println("Please specify ID number from " + sunnyBeach.places.get(0).getId() + " to " + sunnyBeach.places.get(sunnyBeach.places.size() - 1).getId() + " to make reservation");
                try {
                    int idNumber = scanner.nextInt();

                    if (sunnyBeach.places.get(idNumber - 1).getStatus() == PlaceStatus.DIRTY) {
                        System.out.println("Sorry, but right now this place is dirty and cannot be reserved ");
                    } else if (sunnyBeach.places.get(idNumber - 1).getStatus() == PlaceStatus.RESERVED) {
                        System.out.println("Sorry, but this place is already reserved at that time");

                    } else {
                        sunnyBeach.getPlaces().get(idNumber - 1).setStatus(PlaceStatus.RESERVED);
                    }
                } catch (Exception e) {
                    System.out.println("Please be sure to type Integer within the bounds");
                }

            } else if (answer.equals("c")) {
                System.out.println("Please specify ID number from " + sunnyBeach.places.get(0).getId() + " to " + sunnyBeach.places.get(sunnyBeach.places.size() - 1).getId() + " to cancel reservation");

                try {
                    int idNumberCancel = scanner.nextInt();
                    sunnyBeach.getPlaces().get(idNumberCancel - 1).setStatus((PlaceStatus.FREE));
                } catch (Exception e) {
                    System.out.println("Please be sure to type Integer within the bounds");
                }

            } else if (answer.equals("s")) {
                for (int i = 0; i < sunnyBeach.places.size(); i++)
                    System.out.println(sunnyBeach.places.get(i));
            } else if (answer.equals("q")) {
                flag = false;
            }


        }
        Reservations reservations =new Reservations();
        reservations.makeReservations();
    }
}
