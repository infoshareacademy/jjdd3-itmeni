package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.PlaceStatus;

import java.util.Scanner;

public class Reservation {

    public void makeReservation(Beach beach, Scanner scanner) {
        System.out.println("Please specify ID number from " + beach.getPlaces().get(0).getId() + " to " + beach.getPlaces().get(beach.getPlaces().size() - 1).getId() + " to make reservation");
        try {
            int idNumber = Integer.parseInt(scanner.nextLine());

            if (beach.getPlaces().get(idNumber - 1).getStatus() == PlaceStatus.DIRTY) {
                System.out.println("Sorry, but right now this place is dirty and cannot be reserved ");
            } else if (beach.getPlaces().get(idNumber - 1).getStatus() == PlaceStatus.RESERVED) {
                System.out.println("Sorry, but this place is already reserved at that time");

            } else {
                beach.getPlaces().get(idNumber - 1).setStatus(PlaceStatus.RESERVED);
            }
        } catch (Exception e) {
            System.out.println("Please be sure to type Integer within the bounds");
        }
    }

    public boolean reserve (Beach beach, int idNum) {
        if (beach.getPlaces().get(idNum - 1).getStatus() == PlaceStatus.DIRTY) {
            System.out.println("Sorry, but right now this place is dirty and cannot be reserved ");
            return false;
        } else if (beach.getPlaces().get(idNum - 1).getStatus() == PlaceStatus.RESERVED) {
            System.out.println("Sorry, but this place is already reserved at that time");
            return false;
        } else {
            beach.getPlaces().get(idNum - 1).setStatus(PlaceStatus.RESERVED);
            return true;
        }
    }

    public boolean dirty (Beach beach, int idNum) {
        if (beach.getPlaces().get(idNum - 1).getStatus() == PlaceStatus.DIRTY) {
            System.out.println("Sorry, but right now this place is dirty and cannot be reserved ");
            return true;
        } else if (beach.getPlaces().get(idNum - 1).getStatus() == PlaceStatus.RESERVED) {
            System.out.println("Sorry, but this place is already reserved at that time");
            return false;
        } else {
            beach.getPlaces().get(idNum - 1).setStatus(PlaceStatus.RESERVED);
            return false;
        }
    }
}
