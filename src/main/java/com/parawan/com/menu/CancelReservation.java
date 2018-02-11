package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.PlaceStatus;

import java.util.Scanner;

public class CancelReservation {
    public void undoReservation(Beach beach, Scanner scanner){
        System.out.println("Please specify ID number from " + beach.getPlaces().get(0).getId() + " to " + beach.getPlaces().get(beach.getPlaces().size() - 1).getId() + " to cancel reservation");

        try {
            int idNumberCancel = Integer.parseInt(scanner.nextLine());
            beach.getPlaces().get(idNumberCancel - 1).setStatus((PlaceStatus.FREE));
        } catch (Exception e) {
            System.out.println("Please be sure to type Integer within the bounds");
        }
    }
}
