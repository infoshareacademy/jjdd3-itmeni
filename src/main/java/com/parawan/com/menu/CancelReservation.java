package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.reservation.ReservationTable;

import java.util.Scanner;

public class CancelReservation {
    private int cancelId = 0;
    private int cancelHour = 0;

    public void undoReservation(Beach beach, Scanner scanner, ReservationTable reservationTable) {

        while (conditionForId(beach)) {

            System.out.println("Please specify ID number from " + beach.getPlaces().get(0).getId() + " to " + beach.getPlaces().get(beach.getPlaces().size() - 1).getId() + " to cancel reservation");
            try {
                cancelId = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please be sure to type Integer within the bounds");
            }
        }

        while (cancelHour < 8 || cancelHour > 19) {

            System.out.println("Please type hour of reservation You wish to cancel (Beach is open from 8.00 to 19.00)");
            try {
                cancelHour = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please be sure to type Integer within the bounds");
            }
        }

        for (int i = 0; i < reservationTable.size(); ++i) {
            if (conditionForCancellation(reservationTable, i)) {
                reservationTable.remove(i);
            }
        }
    }

    private boolean conditionForId(Beach beach){

        return cancelId < beach.getPlaces().get(0).getId() || cancelId > beach.getPlaces().get(beach.getPlaces().size() - 1).getId();
    }

    private boolean conditionForCancellation(ReservationTable reservationTable, int i){

        return reservationTable.get(i).getHourOfReservation() == cancelHour && reservationTable.get(i).getPlaceId() == cancelId;
    }
}
