package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.reservation.ReservationTable;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CancelReservation {
    private Integer cancelId = 0;
    private Integer cancelHour = 0;
    private final Logger LOGGER = LoggerFactory.getLogger(CancelReservation.class);

    public void setCancelId(Integer cancelId) {
        this.cancelId = cancelId;
    }

    public void setCancelHour(Integer cancelHour) {
        this.cancelHour = cancelHour;
    }

    public void undoReservation(Beach beach, Scanner scanner, ReservationTable reservationTable) {

        while (conditionForId(beach)) {

            System.out.println("Please specify ID number from " + beach.getPlaces().get(0).getId() + " to " + beach.getPlaces().get(beach.getPlaces().size() - 1).getId() + " to cancel reservation");
            try {
                cancelId = Integer.parseInt(scanner.nextLine());
                LOGGER.debug("Canceled reservation for place with ID {}.", cancelId);
            } catch (Exception e) {
                System.out.println("Please be sure to type Integer within the bounds");
                LOGGER.warn("Wrong type for ID number was selected.");
            }
        }

        while (cancelHour < 8 || cancelHour > 19) {

            System.out.println("Please type hour of reservation You wish to cancel (Beach is open from 8.00 to 19.00)");
            try {
                cancelHour = Integer.parseInt(scanner.nextLine());
                LOGGER.debug("Canceled reservation for place with ID {}.", cancelId);
            } catch (Exception e) {
                System.out.println("Please be sure to type Integer within the bounds");
                LOGGER.warn("Wrong type for hour was selected.");
            }
        }
        cancel(reservationTable);
    }

    private boolean conditionForId(Beach beach) {

        return cancelId < beach.getPlaces().get(0).getId() || cancelId > beach.getPlaces().get(beach.getPlaces().size() - 1).getId();
    }

    private boolean conditionForCancellation(ReservationTable reservationTable, int i) {

        return reservationTable.get(i).getHourOfReservation() == cancelHour && reservationTable.get(i).getPlaceId() == cancelId;
    }

    public ReservationTable cancel(ReservationTable reservationTable) {
        for (int i = 0; i < reservationTable.size(); ++i) {
            if (conditionForCancellation(reservationTable, i)) {
                reservationTable.remove(i);
            }
        }
        return reservationTable;
    }
}