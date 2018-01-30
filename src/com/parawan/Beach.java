package com.parawan;

import java.util.ArrayList;

public class Beach extends ArrayList {

    public Beach() {


    }

    public void createPlaces() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 200; i++) {

            Place place = new Place(i, x, y, PlaceStatus.FREE);
            this.add(place);
            x++;

            if (x >= 20) {
                x = 0;
                y++;
            }

        }

    }


}
