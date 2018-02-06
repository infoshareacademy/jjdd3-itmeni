package com.parawan;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.util.ArrayList;
import java.util.List;

public class JavaToXML {
    public void javaToXML() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PlacesWrapper.class, Places.class, Place.class, PlaceStatus.class);

        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Places places = new Places();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1 ; j <= 10 ; j++) {
                places.add(new Place((i - 1)*10 + j, i-1, j-1, PlaceStatus.FREE));
            }
        }

        PlacesWrapper placesWrapper = new PlacesWrapper();
        placesWrapper.setPlaces(places);
        m.marshal(placesWrapper, System.out);
    }
}