package com.parawan;

public class PlaceCompare {

    Beach beach;


    public Beach getBeach() {
        return beach;
    }

    public void setBeach(Beach beach) {
        this.beach = beach;
    }

    public boolean comparePlaces(Place placeMain, Place placeToCompare) {

       if(placeMain.getStatus() == placeToCompare.getStatus()){
           return true;
       }

        for (int i = 0; i < ItemType.values().length; i++) {
            if (placeMain.getRentedItems().containsKey(ItemType.values()[i])
                    && placeToCompare.getRentedItems().containsKey(ItemType.values()[i])){
                return true;
            }
        }
        return false;
    }

    public boolean placeNotExist(int x, int y) {
        if (x < 0 || x >= beach.getMaxWidth() || y < 0 || y >= beach.getMaxHeight()) {
            return true;
        }
        return false;
    }

}
