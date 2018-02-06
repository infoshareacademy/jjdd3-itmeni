package com.parawan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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

    public Place() {
    }

    public Place(int id, int x, int y, PlaceStatus status) {


        this.id = id;
        this.x = x;
        this.y = y;
        this.status = status;
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

    public Object getStatus() {
        return status;
    }
    public void showInfo(){
        System.out.println("Id miejsca: " + id + " || " + "" +
                "X: " + x + " || " + "Y: " + y + " || " + "Status: " + status);
    }

    @Override
    public String toString(){
        return "Id miejsca: " + id + " || " + "" +
                "X: " + x + " || " + "Y: " + y + " || " + "Status: " + status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStatus(PlaceStatus status) {
        this.status = status;
    }
}
