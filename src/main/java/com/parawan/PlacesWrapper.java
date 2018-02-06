package com.parawan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "places")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlacesWrapper {

    @XmlElement(name = "place")
    private Places places = new Places();

    public Places getPlaces() {
        return places;
    }

    public void setPlaces(Places places) {
        this.places = places;
    }
}