package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.PlaceStatus;

import java.util.Scanner;

public class CancelReservation {
    public void undoReservation(Beach beach, Scanner scanner) {
        System.out.println("Please specify ID number from " + beach.getPlaces().get(0).getId() + " to " + beach.getPlaces().get(beach.getPlaces().size() - 1).getId() + " to cancel reservation");

        try {
            int idNumberCancel = Integer.parseInt(scanner.nextLine());
            cancel(beach, idNumberCancel);
        } catch (Exception e) {
            System.out.println("Please be sure to type Integer within the bounds");
        }
    }

    public PlaceStatus cancel(Beach beach, int IdInt) {

        beach.getPlaces().get(IdInt - 1).setStatus(PlaceStatus.FREE);
        return beach.getPlaces().get(IdInt - 1).getStatus();
    }
}
