package com.parawan;

import com.parawan.XMLparser.Places;

public interface BeachDao {

    Integer getHourOfStatus();
    String getName();
    void setName(String name);
    void setHourOfStatus(Integer hourOfStatus);
    int getMaxWidth();
    int getMaxHeight();
    Places getPlaces();
    void setPlaces(Places places);
    void createPlaces();
    Place getPlaceByXY(int x, int y);
}
