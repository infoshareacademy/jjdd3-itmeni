package com.parawan;

import java.util.ArrayList;
import java.util.List;

public class Beach {

    private String name;
    private List<Place> places = new ArrayList<>();
    private Integer maxWidth;
    private Integer maxHeight;
    private Integer hourOfStatus;

    public Beach(String name, int maxWidth, int maxHeight) {
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        createPlaces();
    }

    public Integer getHourOfStatus() {
        return hourOfStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
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
            }
        }
        return place;
    }
}