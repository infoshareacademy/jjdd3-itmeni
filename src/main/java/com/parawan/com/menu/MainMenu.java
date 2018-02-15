package com.parawan.com.menu;

/*import com.parawan.*;
import com.parawan.XMLparser.JavaToXML;
import com.parawan.reservation.ReservationTable;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainMenu {
    public void showMenu(Beach beach, JavaToXML javaToXML) throws IOException {

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
}*/

import com.parawan.*;
import com.parawan.XMLparser.JavaToXML;
import com.parawan.reservation.ReservationTable;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainMenu {
    public void showMenu(Beach beach, JavaToXML javaToXML) throws IOException {

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

        ReservationTable reservationTable = new ReservationTable();

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(myFormatter);
        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("\nPrivate beach management system - PARAWAN. ||     date/hour: " + formattedDateTime);
            System.out.println("Please specify Your action.                ||               ver 1.0 ");
            System.out.println("\nWould You like to: [r]eserve place, r[e]serve place with additional requirements," +
                    " \n[c]ancel reservation, [s]ee current beach preview, c[h]eck storehouse status, [q]uit program");

            String answer = scanner.nextLine();

            if (answer.equals("r")) {
                //test
                reservationTable.reservePlace(beach);

            } else if (answer.equals("e")) {

                SearchEngine searchEngine = new SearchEngine();
                searchEngine.search(beach);

            } else if (answer.equals("c")) {
                ShowMap showMap = new ShowMap();
                System.out.println("give hour");
                SnapshotOfGivenHour snapshotOfGivenHour = new SnapshotOfGivenHour();
                snapshotOfGivenHour.setBeachAndReservationTable(beach, reservationTable);
                beach.setHourOfStatus(scanner.nextInt());
                showMap.printMap(snapshotOfGivenHour.getSnapshot(beach.getHourOfStatus()));
                beach.createPlaces();
               /*
               CancelReservation cancelReservation = new CancelReservation();
               cancelReservation.undoReservation(beach, scanner);
               */

            } else if (answer.equals("s")) {
                System.out.println("give hour");
                beach.setHourOfStatus(scanner.nextInt());
                SnapshotOfGivenHour snapshotOfGivenHour = new SnapshotOfGivenHour() ;
                snapshotOfGivenHour.setBeachAndReservationTable(beach, reservationTable);
                snapshotOfGivenHour.getSnapshot(beach.getHourOfStatus());
                SearchEngine searchEngine = new SearchEngine();

               /*
               ReservationPreview reservationPreview = new ReservationPreview();
               reservationPreview.preview(beach);
                 */
                ShowMap showMap = new ShowMap();
                showMap.printMapAfterSearch(searchEngine.search(beach));
                beach.createPlaces();

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