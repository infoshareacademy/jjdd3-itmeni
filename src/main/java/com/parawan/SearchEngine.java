package com.parawan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchEngine {

    private Place temporaryPlace = new Place();
    private String option = "";
    private List<Place> foundSearched = new ArrayList<Place>();
    private int x, y, maxX, maxY;
    private Beach beach;

    public Beach search(Beach beach) {
        this.beach = beach;
        temporaryPlace = new SearchEnginePlaceBuilder().getRequirements();

        temporaryPlace.setX(0);
        temporaryPlace.setY(0);


        for (Place p : beach.getPlaces()) {
            if (checkIfNoNearbyMeetsSearchCriteria(temporaryPlace)) {
                p.setMeetsSearchCriteria(true);
            }

            temporaryPlace.setX(temporaryPlace.getX() + 1);
            if (temporaryPlace.getX() >= beach.getMaxWidth()) {
                temporaryPlace.setX(0);
                temporaryPlace.setY(temporaryPlace.getY() + 1);
            }

        }
        ShowMap sm = new ShowMap();
        sm.printMapAfterSearch(beach);

        return beach;
    }

    public boolean checkIfNoNearbyMeetsSearchCriteria(Place temporaryPlace) {
        x = temporaryPlace.getX();
        y = temporaryPlace.getY();
;
        PlaceCompare pc = new PlaceCompare();
        pc.setBeach(this.beach);

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {

                if (pc.placeNotExist( x + i, y + j)) {
                    continue;
                } else {
                     return (pc.comparePlaces(temporaryPlace, beach.getPlaceByXY(x + i, y + j)));
                }
            }
        }
        /*
        if ((!(x == 0) && (!(y == 0))) && temporaryPlace.getStatus() == beach.getPlaceByXY(x - 1, y - 1).getStatus()) {
            return false;
        }
        if ((!(y == 0)) && temporaryPlace.getStatus() == beach.getPlaceByXY(x, y - 1).getStatus()) {
            return false;
        }
        if (((!(y == 0) && (!(x == maxX)))) && temporaryPlace.getStatus() == beach.getPlaceByXY(x + 1, y - 1).getStatus()) {
            return false;
        }
        if ((!(x == 0)) && temporaryPlace.getStatus() == beach.getPlaceByXY(x - 1, y).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x, y).getStatus()) {
            return false;
        }
        if ((!(x == maxX)) && temporaryPlace.getStatus() == beach.getPlaceByXY(x + 1, y).getStatus()) {
            return false;
        }
        if ((!(x == 0)) && (!(y == beach.getMaxWidth())) && temporaryPlace.getStatus() == beach.getPlaceByXY(x - 1, y + 1).getStatus()) {
            return false;
        }
        if ((!(y == maxY)) && temporaryPlace.getStatus() == beach.getPlaceByXY(x, y + 1).getStatus()) {
            return false;
        }
        if (((!(y == maxY) && (!(x == maxX)))) && temporaryPlace.getStatus() == beach.getPlaceByXY(x + 1, y + 1).getStatus()) {
            return false;
        }
        */
        return true;
    }

}
