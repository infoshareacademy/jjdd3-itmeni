package com.parawan;

import java.util.ArrayList;

public class Beach <T> extends ArrayList {

    int maxWidth;
    int maxHeight;

    public Beach(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public void createPlaces() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < (maxWidth*maxHeight); i++) {

            Place place = new Place((i+1), a, b, PlaceStatus.FREE);
            this.add(place);
            a++;

            if (a >= maxWidth) {
                a = 0;
                b++;
            }
        }
    }
}
