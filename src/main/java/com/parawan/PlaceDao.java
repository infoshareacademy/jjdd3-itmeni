package com.parawan;

import java.util.List;

public interface PlaceDao {

    boolean isMeetSearchCriteria();
    void setMeetsSearchCriteria(boolean meetsSearchCriteria);
    int getId();
    int getX();
    int getY();
    void putItemToRentedItemsList(ItemType accessory);
    PlaceStatus getStatus();
    String toString();
    void setX(int x);
    List<ItemType> getRentedItems();
    void setRentedItems(List<ItemType> rentedItems);
    void setY(int y);
    void setStatus(PlaceStatus status);
}
