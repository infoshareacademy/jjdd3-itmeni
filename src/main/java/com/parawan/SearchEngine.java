package com.parawan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchEngine {

    Place temporaryPlace = new Place();
    String option = "";
    List<Place> foundSearched = new ArrayList<>();
    int x, y, maxX, maxY;

    ShowMap showMap = new ShowMap();
    Beach beach;
    Scanner sc = new Scanner(System.in);


    public void search(Beach beach) {
        this.beach = beach;
        temporaryPlace = new SearchEnginePlaceBuilder().getRequirements();

        temporaryPlace.setX(0);
        temporaryPlace.setY(0);


        for (Place p : beach.getPlaces()) {
            if (checkNearby(temporaryPlace)) {
                p.setMeetsSearchCriteria(true);
            }

            temporaryPlace.setX(temporaryPlace.getX() + 1);
            if (temporaryPlace.getX() >= beach.getMaxWidth()) {
                temporaryPlace.setX(0);
                temporaryPlace.setY(temporaryPlace.getY() + 1);
            }

        }

        showMap.printMapAfterSearch(beach);
    }

    public boolean checkNearby(Place temporaryPlace) {

        x = temporaryPlace.getX();
        y = temporaryPlace.getY();

        maxX = beach.getMaxWidth();
        maxY = beach.getMaxHeight();

        if ((!(x == 0) && (!(y == 0))) && temporaryPlace.getStatus() == beach.getPlaceByXY(x - 1, y - 1).getStatus()) {
            return false;
        }
        if ((!(y == 0)) && temporaryPlace.getStatus() == beach.getPlaceByXY(x, y - 1).getStatus()) {
            return false;
        }
        if (((!(y == 0)&& (!(x == maxX )))) && temporaryPlace.getStatus() == beach.getPlaceByXY(x + 1, y - 1).getStatus()) {
            return false;
        }
        if ((!(x==0)) && temporaryPlace.getStatus() == beach.getPlaceByXY(x - 1, y).getStatus()) {
            return false;
        }
        if (temporaryPlace.getStatus() == beach.getPlaceByXY(x, y).getStatus()) {
            return false;
        }
        if ((!(x==maxX)) && temporaryPlace.getStatus() == beach.getPlaceByXY(x + 1, y).getStatus()) {
            return false;
        }

        if ((!(x==0)) && (!(y == beach.getMaxWidth() )) && temporaryPlace.getStatus() == beach.getPlaceByXY(x - 1, y + 1).getStatus()) {
            return false;
        }
        if ((!(y==maxY))&&temporaryPlace.getStatus() == beach.getPlaceByXY(x, y + 1).getStatus()) {
            return false;
        }
        if (((!(y == maxY)&& (!(x == maxX )))) &&  temporaryPlace.getStatus() == beach.getPlaceByXY(x + 1, y + 1).getStatus()) {
            return false;
        }
        return true;
    }


}
