package com.parawan;

import java.util.Scanner;

public class SearchEnginePlaceBuilder {

    private String option;
    private Scanner sc = new Scanner(System.in);
    private Place placeToAvoid = new Place();

    public Place getRequirements() {
        System.out.println("Do you want no neighbours?\nType Y:");
        option = sc.nextLine().toLowerCase();
        if (option.equals("y")) {
            placeToAvoid.setStatus(PlaceStatus.RESERVED);
        } else {
            placeToAvoid.setStatus(PlaceStatus.FREE);
        }
        System.out.println("Do you want no PARAWANS nearby?\n" +
                "Type Y to confirm");
        option = sc.nextLine().toLowerCase();
        if (option.equals("y")) {
            placeToAvoid.putItems(ItemType.SCREEN, 1);
        }
        System.out.println("Do you want no umbrellas nearby?\n" +
                "Type Y/N");
        option = sc.nextLine().toLowerCase();
        if (option.equals("y")) {
            placeToAvoid.putItems(ItemType.UMBRELLA, 1);
        }
        return placeToAvoid;
    }


}
