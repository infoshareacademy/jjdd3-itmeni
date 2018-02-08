package com.parawan;

import java.util.Scanner;

public class CancelReservation {
    public void undoReservation(Beach beach, Scanner scanner){
        System.out.println("Please specify ID number from " + beach.getPlaces().get(0).getId() + " to " + beach.getPlaces().get(beach.getPlaces().size() - 1).getId() + " to cancel reservation");

        try {
            int idNumberCancel = scanner.nextInt();
            beach.getPlaces().get(idNumberCancel - 1).setStatus((PlaceStatus.FREE));
        } catch (Exception e) {
            System.out.println("Please be sure to type Integer within the bounds");
        }
    }
}
