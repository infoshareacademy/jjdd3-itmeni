package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.PlaceStatus;
import com.parawan.reservation.ReservationTable;

import java.util.Scanner;

public class CancelReservation {
    public void undoReservation(Beach beach, Scanner scanner, ReservationTable reservationTable) {

        int cancelId = 0;
        int cancelHour = 0;

        while (cancelId < beach.getPlaces().get(0).getId() || cancelId > beach.getPlaces().get(beach.getPlaces().size() - 1).getId()) {

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

        for (int i = 0; i < reservationTable.getTableOfReservations().size(); ++i) {
            if (reservationTable.getTableOfReservations().get(i).getHourOfReservation() == cancelHour && reservationTable.getTableOfReservations().get(i).getPlaceId() == cancelId) {
                reservationTable.getTableOfReservations().remove(i);
            }
        }
    }
}
