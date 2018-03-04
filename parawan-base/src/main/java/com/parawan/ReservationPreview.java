package com.parawan;

public class ReservationPreview {

    public void preview(Beach beach) {

        System.out.println("\n");

        for (int y = 0; y < beach.getMaxHeight(); y++) {
            for (int x = 0; x < beach.getMaxWidth(); x++) {
                if (getPlaceByCoordinates(beach, x, y).getStatus() == PlaceStatus.RESERVED) {
                    System.out.print(" #\t");
                } else {
                    System.out.print(getPlaceByCoordinates(beach, x, y).getId() + "\t");
                }
            }
            System.out.println();
        }
        System.out.println("\n                             SEA SIDE");
        System.out.println("\nLegend:\n\n(number) - free place\n       # - reserved place\n");
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