package com.parawan.view;


public class Place {

    private int id;

    private boolean occupied;

    private String rentedItems = "";

    private boolean meetsSearchCriteria;

    public Place() {
    }

    public Place(int id, boolean occupied, String rentedItems, boolean meetsSearchCriteria) {
        this.id = id;
        this.occupied = occupied;
        this.rentedItems = rentedItems;
        this.meetsSearchCriteria = meetsSearchCriteria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(String rentedItems) {
        this.rentedItems = rentedItems;
    }

    public boolean isMeetsSearchCriteria() {
        return meetsSearchCriteria;
    }

    public void setMeetsSearchCriteria(boolean meetsSearchCriteria) {
        this.meetsSearchCriteria = meetsSearchCriteria;
    }
}