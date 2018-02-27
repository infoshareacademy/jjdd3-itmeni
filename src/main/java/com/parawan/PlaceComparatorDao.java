package com.parawan;

public interface PlaceComparatorDao {

    void setBeach(Beach beach);
    boolean comparePlaces(Place placeMain, Place placeToCompare);
    boolean placeNotExist(int x, int y);
}
