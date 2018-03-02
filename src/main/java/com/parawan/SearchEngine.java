package com.parawan;

import com.parawan.com.menu.ReservationWithRequirements;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private Place temporaryPlace = new Place();
    private String option = "";
    private List<Place> foundSearched = new ArrayList<Place>();
    private int x, y, maxX, maxY;
    private Beach beach;

    public Beach search(Beach beach) {
        this.beach = beach;
        temporaryPlace = new ReservationWithRequirements().getRequirements();

        temporaryPlace.setX(0);
        temporaryPlace.setY(0);


        for (Place p : beach.getPlaces()) {
            if (!checkIfNoNearbyMeetsSpecifiedCriteria(temporaryPlace)) {
                p.setMeetsSearchCriteria(true);
            }

            temporaryPlace.setX(temporaryPlace.getX() + 1);
            if (temporaryPlace.getX() >= beach.getMaxWidth()) {
                temporaryPlace.setX(0);
                temporaryPlace.setY(temporaryPlace.getY() + 1);
            }
        }
        return beach;
    }

    public boolean checkIfNoNearbyMeetsSpecifiedCriteria(Place temporaryPlace) {
        x = temporaryPlace.getX();
        y = temporaryPlace.getY();
        maxX = beach.getMaxWidth();
        maxY = beach.getMaxHeight();
        PlaceComparator pc = new PlaceComparator();
        pc.setBeach(this.beach);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (pc.placeNotExist(x + i, y + j)) {
                    continue;
                } else {
                    if (pc.comparePlaces(temporaryPlace, beach.getPlaceByXY(x + i, y + j))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
