package com.parawan;

import java.util.ArrayList;

public class Beach<T> extends ArrayList {

    int maxWidth;
    int maxHeight;

    public Beach(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public void createPlaces() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < (maxWidth*maxHeight); i++) {

            Place place = new Place((i+1), x, y, PlaceStatus.FREE);
            this.add(place);
            x++;

            if (x >= maxWidth) {
                x = 0;
                y++;
            }

        }

    }


}
