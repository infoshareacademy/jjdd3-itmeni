package com.parawan;

import java.util.Scanner;

public class Place {

    private String positionX;
    private long positionY;
    private PlaceStatus status;

    public Place(String positionX, long positionY, PlaceStatus status) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.status = status;
    }
    public String getPositionX() {
        return positionX;
    }
    public long getPositionY() {
        return positionY;
    }
    public PlaceStatus getStatus() {
        return status;
    }
    public void setStatus(PlaceStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
     return status.toString();
    }
}
