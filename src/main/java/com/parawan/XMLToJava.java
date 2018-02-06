package com.parawan;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLToJava {

    public void xmlToJava() {
        try {
            JAXBContext jc = JAXBContext.newInstance(PlacesWrapper.class, Places.class, Place.class, PlaceStatus.class);
            Unmarshaller u = jc.createUnmarshaller();

            File f = new File("./booking.xml");
            Place product = new Place();
            product = (Place) u.unmarshal(f);

            System.out.println(product.getId());
            System.out.println(product.getX());
            System.out.println(product.getY());
            System.out.println(product.getStatus());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}