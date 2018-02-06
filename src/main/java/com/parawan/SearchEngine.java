package com.parawan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchEngine {

    Place temporaryPlace = new Place();
    String option = "";
    List<Place> foundSearched = new ArrayList<>();
    int x, y;


    Beach beach;
    Scanner sc = new Scanner(System.in);

    public SearchEngine(Beach beach) {
        this.beach = beach;
    }

    public void search() {
        temporaryPlace = new SearchEnginePlaceBuilder().getRequirements();

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

        x = temporaryPlace.getX();
        y = temporaryPlace.getY();


        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x - 1, y - 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x, y - 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x + 1, y - 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x, y).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x - 1, y).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x + 1, y).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x - 1, y + 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x, y + 1).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x + 1, y + 1).getStatus()) {
            return false;
        }
        return true;

    }
}
