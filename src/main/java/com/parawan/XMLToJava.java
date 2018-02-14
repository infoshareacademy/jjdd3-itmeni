package com.parawan;

import java.io.File;

import javax.xml.bind.*;

public class XMLToJava {

    public Places xmlToJava(String path) {
        PlacesWrapper placesWrapper;
        Places placesFromFile = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(PlacesWrapper.class, Places.class, Place.class, PlaceStatus.class);
            Unmarshaller u = jc.createUnmarshaller();

            u.setEventHandler(
                    new ValidationEventHandler() {
                        public boolean handleEvent(ValidationEvent event) {
                            System.out.println(event.getMessage());
                            return true;
                        }
                    });

            File f = new File(path);

            placesWrapper = (PlacesWrapper) u.unmarshal(f);
            placesFromFile = placesWrapper.getPlaces();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return placesFromFile;
    }
}