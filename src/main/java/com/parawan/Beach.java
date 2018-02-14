package com.parawan;

import java.util.ArrayList;
import java.util.List;

public class Beach {

    private Places places = new Places();
    private Integer maxWidth;
    private Integer maxHeight;
    private Integer hourOfStatus;

    public Beach(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public Integer getHourOfStatus() {
        return hourOfStatus;
    }

    public void setHourOfStatus(Integer hourOfStatus) {
        this.hourOfStatus = hourOfStatus;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public Places getPlaces() {
        return places;
    }

    public void setPlaces(Places places) {
        this.places = places;
    }

    public void createPlaces() {
        this.places.clear();
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

    public Place getPlaceByXY(int x, int y) {
        Place place = null;
        for (int i = 0; i < places.size(); i++) {
            if ((places.get(i).getX() == x) && (places.get(i).getY() == y)) {
                place = places.get(i);
                break;
            }
        }
        return place;
    }
}