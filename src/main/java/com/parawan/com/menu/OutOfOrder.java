package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.PlaceStatus;

import java.util.Scanner;

public class OutOfOrder {
    public void makeUnavailable(Beach beach, Scanner scanner) {
        System.out.println("Please specify ID number from " + beach.getPlaces().get(0).getId() + " to " + beach.getPlaces().get(beach.getPlaces().size() - 1).getId() + " to set place to out of order");

        try {
            int idNumberOutOrder = Integer.parseInt(scanner.nextLine());
            out(beach, idNumberOutOrder);
        } catch (Exception e) {
            System.out.println("Please be sure to type Integer within the bounds");
        }
    }

    public PlaceStatus out(Beach beach, int IdInt) {

        beach.getPlaces().get(IdInt - 1).setStatus(PlaceStatus.OUTOFORDER);
        return beach.getPlaces().get(IdInt - 1).getStatus();
    }
}
