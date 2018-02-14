package com.parawan;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ReservationPreview {

    public void preview(Beach beach) {
        for (int i = 0; i < beach.getMaxWidth(); i++) {
            if (i == 0) {
                System.out.print("    ");
            }
            System.out.print(i + 1 + "  ");
        }
        System.out.println();
        for (int y = 0; y < beach.getMaxHeight(); y++) {
            System.out.print(y + 1 + "  ");
            for (int x = 0; x < beach.getMaxWidth(); x++) {
                if (getPlaceByCoordinates(beach, x, y).getStatus() == PlaceStatus.RESERVED) {
                    System.out.print("#   ");
                } else if (getPlaceByCoordinates(beach, x, y).getStatus() == PlaceStatus.OUTOFORDER) {
                    System.out.print("*   ");
                } else {
                    System.out.print(".   ");
                }
            }
            System.out.println();
        }
        System.out.println("\n                             SEA SIDE");
        System.out.println("\nLegend:\n. - free place\n* - out of order\n# - reserved place");
    }

    public Place getPlaceByCoordinates(Beach beach, int x, int y) {
        if (x >= beach.getMaxWidth() || y >= beach.getMaxHeight()) {
            throw new IllegalArgumentException("Wow-out of range!");
        }
        return beach.getPlaces().stream()
                .filter(place -> place.getX() == x && place.getY() == y)
                .findFirst()
                .orElse(null);
    }
}