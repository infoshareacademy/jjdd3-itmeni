package com.parawan;

import java.util.ArrayList;
import java.util.List;

public class Beach {

    int maxWidth;
    int maxHeight;
    Places places = new Places();

    public Beach(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void createPlaces() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < (maxWidth * maxHeight); i++) {

            Place place = new Place((i + 1), x, y, PlaceStatus.FREE);
            places.add(place);
            x++;

            if (x >= maxWidth) {
                x = 0;
                y++;
            }
        }
    }

    public void setPlaces(Places places) {
        this.places = places;
    }
}