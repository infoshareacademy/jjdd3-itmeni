package com.parawan.com.menu;

import com.parawan.*;
import com.parawan.reservation.ReservationTable;

import javax.xml.bind.JAXBException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainMenu {
    public void showMenu(Beach beach, JavaToXML javaToXML) {

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

        ReservationTable reservationTable = new ReservationTable();


        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(myFormatter);
        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("\nPrivate beach management system - PARAWAN. ||     date/hour: " + formattedDateTime);
            System.out.println("Please specify Your action.                ||               ver 1.0 ");
            System.out.println("\nWould You like to: [r]eserve place, r[e]serve place with additional requirements," +
                    " \n[c]ancel reservation, [s]ee current beach preview, c[h]eck storehouse status,\n" +
                    "se[t] place to be out of order, [q]uit program");

            String answer = scanner.nextLine();

            if (answer.equals("r")) {
                //test
                reservationTable.reservePlace(beach);

            } else if (answer.equals("e")) {

                SearchEngine searchEngine = new SearchEngine();
                searchEngine.search(beach);

            } else if (answer.equals("c")) {

                CancelReservation cancelReservation = new CancelReservation();
                cancelReservation.undoReservation(beach, scanner);

            } else if (answer.equals("s")) {

                ReservationPreview reservationPreview = new ReservationPreview();
                reservationPreview.preview(beach);

            } else if (answer.equals("t")) {

                OutOfOrder outOfOrder = new OutOfOrder();
                outOfOrder.makeUnavailable(beach, scanner);
                
            } else if (answer.equals("q")) {

                try {
                    javaToXML.savePlacesToXML(beach.getPlaces());
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                System.out.println("Thank you for using PARAWAN - your private beach management system");
                break;
            }
        }
    }
}
