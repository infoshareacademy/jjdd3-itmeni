package com.parawan;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ReservationPreview {
    private Place place;

    public void preview(Beach beach) {
        for (int i = 0; i < beach.getMaxWidth(); i++) {
            System.out.println();
        }
        for (int y = 0; y < beach.getMaxHeight(); y++) {
            for (int x = 0; x < beach.getMaxWidth(); x++) {
                if (getPlaceByCoordinates(beach, x, y).getStatus() == PlaceStatus.RESERVED) {
                    System.out.print(" #\t");
                } else if (getPlaceByCoordinates(beach, x, y).getStatus() == PlaceStatus.OUTOFORDER) {
                    System.out.print(" *\t");
                } else {
                    System.out.print(getPlaceByCoordinates(beach, x, y).getId() + "\t");
                }
            }
            System.out.println();
        }
        System.out.println("\n                             SEA SIDE");
        System.out.println("\nLegend:\n. - free place\n* - out of order\n# - reserved place");
    }

    public Place getPlaceByCoordinates(Beach beach, int x, int y) {
        if (x >= beach.getMaxWidth() || y >= beach.getMaxHeight()) {
            throw new IllegalArgumentException();
        }
        return beach.getPlaces().stream()
                .filter(place -> place.getX() == x && place.getY() == y)
                .findFirst()
                .get();
    }
}