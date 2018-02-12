package com.parawan.com.menu;

import com.parawan.ItemType;
import com.parawan.Place;
import com.parawan.PlaceStatus;

import java.util.Scanner;

public class ReservationWithRequirements {

    private String option;
    private Scanner sc = new Scanner(System.in);
    private Place placeToAvoid = new Place();

    public Place getRequirements() {
        System.out.println("Do you want place with no neighbours around? Please type [y]es or [n]o :");
        option = sc.nextLine();
        if (option.equals("y")) {
            placeToAvoid.setStatus(PlaceStatus.RESERVED);
        } else {
            placeToAvoid.setStatus(PlaceStatus.FREE);
        }
        System.out.println("Do you want place with no PARAWANS around? Please type [y]es or [n]o :");
        option = sc.nextLine();
        if (option.equals("y")) {
            placeToAvoid.putItems(ItemType.SCREEN, 1);
        }
        System.out.println("Do you want place with no umbrellas around? Please type [y]es or [n] :");
        option = sc.nextLine().toLowerCase();
        if (option.equals("y")) {
            placeToAvoid.putItems(ItemType.UMBRELLA, 1);
        }
        return placeToAvoid;
    }
}
