package com.parawan;

public class PlaceComparator {

    private Beach beach;


    public Beach getBeach() {
        return beach;
    }

    public void setBeach(Beach beach) {
        this.beach = beach;
    }

    public boolean comparePlaces(Place placeMain, Place placeToCompare) {

        if (placeMain.getStatus() == placeToCompare.getStatus()) {
            return true;
        }

        for (int i = 0; i < ItemType.values().length; i++) {
            return ((placeMain.getRentedItems().contains(ItemType.values()[i])
                    && placeToCompare.getRentedItems().contains(ItemType.values()[i])));
        }
        return false;
    }

    public boolean placeNotExist(int x, int y) {
        return  (x < 0 || x >= beach.getMaxWidth() || y < 0 || y >= beach.getMaxHeight());
    }

}
