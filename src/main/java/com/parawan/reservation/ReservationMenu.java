package com.parawan.reservation;

import com.parawan.Beach;
import com.parawan.ItemType;
import com.parawan.ReservationPreview;
import com.parawan.SnapshotOfGivenHour;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Scanner;

public class ReservationMenu {
    private final Logger LOGGER = LoggerFactory.getLogger(ReservationMenu.class);
    private Scanner sc = new Scanner(System.in);

    private String chosenItems;
    private String chosenName;
    private Reservation reservation = new Reservation();

    public Reservation makeReservation(Beach beach, ReservationTable reservationTable) {
        CheckStatus checkStatus = new CheckStatus(reservationTable);

        do {
            Integer chosenId = 0;
            Integer chosenHour = 0;
            while (chosenHour < 8 || chosenHour > 19) {

                System.out.println("Please type hour of reservation (Beach is open from 8.00 to 19.00)");

                try {
                    chosenHour = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    LOGGER.warn("Wrong type for hour was selected.");
                    System.out.println("Please be sure to type Integer within the bounds");
                }
            }
            reservation.setHourOfReservation(chosenHour);

            while (chosenId < beach.getPlaces().get(0).getId() || chosenId > beach.getPlaces().get(beach.getPlaces().size() - 1).getId()) {

                System.out.println("\nBeach status at " + chosenHour + ":00");
                ReservationPreview reservationPreview = new ReservationPreview();
                SnapshotOfGivenHour snapshotOfGivenHour = new SnapshotOfGivenHour();
                snapshotOfGivenHour.setBeachAndReservationTable(beach, reservationTable);
                reservationPreview.preview(snapshotOfGivenHour.getSnapshot(chosenHour));

                System.out.println("Please specify ID number from " + beach.getPlaces().get(0).getId() + " to " + beach.getPlaces().get(beach.getPlaces().size() - 1).getId() + " to make reservation");

                try {
                    chosenId = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    LOGGER.warn("Wrong type for place ID number was selected.");
                    System.out.println("Please be sure to type Integer within the bounds");
                }
            }

            reservation.setPlaceId(chosenId);
            System.out.println("Please type your name ");
            chosenName = sc.nextLine();
            LOGGER.trace("Place {} is booked by {}.", chosenId, chosenName);
            reservation.setNameOfPerson(chosenName);

            if (checkStatus.isAlreadyReserved(reservation)) {
                System.out.println("\nSorry, but this place is already reserved at that time\n");
                LOGGER.trace("Selected place is already booked.");
            }

        } while (checkStatus.isAlreadyReserved(reservation));

        System.out.println("Please select items to rent: [s]creen, [u]mbrella, [t]owel, sun[b]ed, [n]othing.");
        System.out.println("For example if You wish to rent: screen, towel and sunbed, type: stb");
        chosenItems = sc.next();
        LOGGER.trace("Is rented : {}", chosenItems);
        analyzeChosenItems(chosenItems);
        return this.reservation;
    }

    public void analyzeChosenItems(String options) {

        if (options.contains("s")) {
            reservation.putRentedItemOnList(ItemType.SCREEN);
        }
        if (options.contains("u")) {
            reservation.putRentedItemOnList(ItemType.UMBRELLA);
        }
        if (options.contains("t")) {
            reservation.putRentedItemOnList(ItemType.TOWEL);
        }
        if (options.contains("b")) {
            reservation.putRentedItemOnList(ItemType.SUNBED);
        }
    }
}
