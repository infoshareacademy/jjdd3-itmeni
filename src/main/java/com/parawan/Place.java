package com.parawan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)

public class Place {

    /*
    indywidualne id oraz współrzędne
     */

    @XmlElement(required = true)
    private int id, x, y;

    @XmlElement(required = true)
    private PlaceStatus status;

    private Map<ItemType, Integer> rentedItems = new HashMap<ItemType, Integer>();

    private boolean meetsSearchCriteria = false;

    public Place() {
    }

    public Place(int id, int x, int y, PlaceStatus status) {

        this.id = id;
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public boolean isMeetSearchCriteria() {
        return meetsSearchCriteria;
    }

    public void setMeetsSearchCriteria(boolean meetsSearchCriteria) {
        this.meetsSearchCriteria = meetsSearchCriteria;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void putItems(ItemType o, Integer h) {
        rentedItems.put(o, h);
    }

    public PlaceStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Id miejsca: " + id + " || " + "" +
                "X: " + x + " || " + "Y: " + y + " || " + "Status: " + status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Map<ItemType, Integer> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(Map<ItemType, Integer> rentedItems) {
        this.rentedItems = rentedItems;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStatus(PlaceStatus status) {
        this.status = status;
    }
}
