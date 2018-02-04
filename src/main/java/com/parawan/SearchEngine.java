package com.parawan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchEngine {

    Place temporaryPlace = new Place();
    String option = "";
    List<Place> foundSearched = new ArrayList<>();

    Beach beach;
    Scanner sc = new Scanner(System.in);

    public SearchEngine(Beach beach) {
        this.beach = beach;
    }

    public void search() {
        System.out.println("Do you want no neighbours?\nType Y:");
        option = sc.nextLine().toLowerCase();
        if (option.equals("y")) {
            temporaryPlace.setStatus(PlaceStatus.RESERVED);
        } else {
            temporaryPlace.setStatus(PlaceStatus.FREE);
        }
        System.out.println("Do you want no PARAWANS nearby?\n" +
                "Type Y to confirm");
        option = sc.nextLine().toLowerCase();
        if (option.equals("y")) {
            temporaryPlace.putItems(ItemType.SCREEN, 1);
        }
        temporaryPlace.setX(0);
        temporaryPlace.setY(0);
        for (Place p : beach.getPlaces()) {
            if (checkNearby(temporaryPlace)) {
                foundSearched.add(p);
                p.showInfo();
           }

            temporaryPlace.setX(temporaryPlace.getX() + 1);
            if (temporaryPlace.getX() > beach.maxWidth) {
                temporaryPlace.setX(0);
                temporaryPlace.setY(temporaryPlace.getY() + 1);
            }

        }
    }

    public boolean checkNearby(Place temporaryPlace) {

        if (temporaryPlace.getStatus() == beach.getPlaceByXY(temporaryPlace.getX() - 1,
                temporaryPlace.getY() - 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(temporaryPlace.getX(),
                temporaryPlace.getY() - 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(temporaryPlace.getX() + 1,
                temporaryPlace.getY() - 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(temporaryPlace.getX() - 1,
                temporaryPlace.getY()).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(temporaryPlace.getX() + 1,
                temporaryPlace.getY()).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(temporaryPlace.getX() - 1,
                temporaryPlace.getY() + 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(temporaryPlace.getX(),
                temporaryPlace.getY() + 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(temporaryPlace.getX() + 1,
                temporaryPlace.getY() + 1).getStatus()) {
            return false;
        }

        return true;

    }
}
