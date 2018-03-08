package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.ReservationPreview;
import com.parawan.SearchEngine;
import com.parawan.SnapshotOfGivenHour;
import com.parawan.datamanager.WriteReservationsToFile;
import com.parawan.reservation.ReservationTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainMenu {
    private final Logger LOG = LoggerFactory.getLogger(MainMenu.class);

    public void showMenu(Beach beach, ReservationTable reservationTable) throws IOException {

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(myFormatter);

        Scanner scanner = new Scanner(System.in);
        ReservationPreview reservationPreview = new ReservationPreview();
        SnapshotOfGivenHour snapshotOfGivenHour = new SnapshotOfGivenHour();

        while (true) {

            System.out.println("\nPrivate beach management system - PARAWAN. ||     Current time: " + formattedDateTime);
            System.out.println("Chose action.                              ||               ver 1.0 ");
            System.out.println("\nWould You like to: [r]eserve place, [f]ind place with additional requirements," +
                    " \n[c]ancel reservation, [s]ee current beach preview, \nc[h]eck the number of items available for rent, [q]uit ");

            String answer = scanner.nextLine();

            if (answer.equals("r")) {
                reservationTable.reservePlace(beach);

            } else if (answer.equals("f")) {

                beach.setHourOfStatus(chooseHour(scanner));
                snapshotOfGivenHour.setBeachAndReservationTable(beach, reservationTable);
                snapshotOfGivenHour.getSnapshot(beach.getHourOfStatus());
                SearchEngine searchEngine = new SearchEngine();
                ShowMapAfterSearch showMap = new ShowMapAfterSearch();
                showMap.printMapAfterSearch(searchEngine.search(beach));
                beach.createPlaces();

            } else if (answer.equals("c")) {

                CancelReservation cancelReservation = new CancelReservation();
                cancelReservation.undoReservation(beach, scanner, reservationTable);

            } else if (answer.equals("s")) {
                beach.setHourOfStatus(chooseHour(scanner));
                snapshotOfGivenHour.setBeachAndReservationTable(beach, reservationTable);
                reservationPreview.preview(snapshotOfGivenHour.getSnapshot(beach.getHourOfStatus()));

            } else if (answer.equals("h")) {

                ItemManagement itemManagement = new ItemManagement();
                itemManagement.itemCount(reservationTable, scanner);

            } else if (answer.equals("q")) {

                WriteReservationsToFile wr = new WriteReservationsToFile();
                try {
                    wr.writeReservationsToFile(reservationTable, beach);
                } catch (FileNotFoundException e){
                    LOG.error("No file to write to.");
                }

                System.out.println("Thank you for using PARAWAN - your private beach management system");
                LOG.info("Log out from system.");

                break;
            }
        }
    }

    public Integer chooseHour(Scanner scanner) {

        int typedHour = 0;

        while (typedHour < 8 || typedHour > 19) {
            System.out.println("Please type hour that interest You  (Beach is open from 8.00 to 19.00)");
            try {
                typedHour = Integer.parseInt(scanner.nextLine());
                LOG.debug("Selected our {} to check booked places.", typedHour);
            } catch (Exception e) {
                System.out.println("Please be sure to type Integer within the bounds");
                LOG.warn("Wrong type for hour was selected.");
            }
        }
        return typedHour;
    }
}
