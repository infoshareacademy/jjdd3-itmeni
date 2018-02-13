package com.parawan.reservation;

import com.parawan.ItemType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reservation {

    private Integer hourOfReservation;
    private Integer placeId;
    private List<ItemType> rentedItems = new ArrayList<ItemType>();
    private String nameOfPerson;

    public Integer getHourOfReservation() {
        return hourOfReservation;
    }

    public void setHourOfReservation(Integer hourOfReservation) {
        this.hourOfReservation = hourOfReservation;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public List<ItemType> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(List<ItemType> rentedItems) {
        this.rentedItems = rentedItems;
    }

    public void putRentedItemOnList(ItemType item) {
        this.rentedItems.add(item);
    }

    public void removeRentedItemFromList(ItemType item) {
        this.rentedItems.remove(item);
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Reservation)) {
            return false;
        }
        Reservation r = (Reservation) o;
        return (Integer.compare(this.hourOfReservation, r.hourOfReservation) == 0 &&
                Integer.compare(this.placeId, r.placeId) == 0);
    }
}
