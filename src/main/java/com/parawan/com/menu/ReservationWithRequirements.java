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
            placeToAvoid.putItemToRentedItemsList(ItemType.SCREEN);
        }
        System.out.println("Do you want place with no umbrellas around? Please type [y]es or [n]o :");
        option = sc.nextLine();
        if (option.equals("y")) {
            placeToAvoid.putItemToRentedItemsList(ItemType.UMBRELLA);
        }
        return placeToAvoid;
    }
}
