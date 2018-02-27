package com.parawan.reservation;

import com.parawan.ItemType;

import java.util.List;

public interface ReservationDao {


    Integer getHourOfReservation();
    void setHourOfReservation(Integer hourOfReservation);
    Integer getPlaceId();
    void setPlaceId(Integer placeId);
    List<ItemType> getRentedItems();
    void putRentedItemOnList(ItemType item);
    String getNameOfPerson();
    void setNameOfPerson(String nameOfPerson);
    int hashCode();
    boolean equals(Object o);
}
