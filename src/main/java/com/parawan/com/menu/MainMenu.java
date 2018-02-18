package com.parawan.com.menu;

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
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(myFormatter);

        ReservationTable reservationTable = new ReservationTable();
        Scanner scanner = new Scanner(System.in);
        ReservationPreview reservationPreview = new ReservationPreview();


        while (true) {

            System.out.println("\nPrivate beach management system - PARAWAN. ||     Current time: " + formattedDateTime);
            System.out.println("Chose action.                              ||               ver 1.0 ");
            System.out.println("\nWould You like to: [r]eserve place, [f]ind place with additional requirements," +
                    " \n[c]ancel reservation, [s]ee current beach preview, \nc[h]eck the number of items available for rent, [q]uit ");

            String answer = scanner.nextLine();

            if (answer.equals("r")) {
                reservationTable.reservePlace(beach);

            } else if (answer.equals("f")) {
                int typedHour = 0;

                while (typedHour < 8 || typedHour > 19) {
                    System.out.println("Please type hour that interest You  (Beach is open from 8.00 to 19.00)");

                    try {
                        typedHour = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Please be sure to type Integer within the bounds");
                    }
                }

                beach.setHourOfStatus(typedHour);
                SnapshotOfGivenHour snapshotOfGivenHour = new SnapshotOfGivenHour();
                snapshotOfGivenHour.setBeachAndReservationTable(beach, reservationTable);
                snapshotOfGivenHour.getSnapshot(beach.getHourOfStatus());
                SearchEngine searchEngine = new SearchEngine();

                ShowMap showMap = new ShowMap();
                showMap.printMapAfterSearch(searchEngine.search(beach));
                beach.createPlaces();

            } else if (answer.equals("c")) {

                CancelReservation cancelReservation = new CancelReservation();
                cancelReservation.undoReservation(beach, scanner, reservationTable);

            } else if (answer.equals("s")) {

                reservationPreview.preview(beach);

            } else if (answer.equals("h")) {

                ItemManagement itemManagement = new ItemManagement();
                itemManagement.itemCount(reservationTable, scanner);

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