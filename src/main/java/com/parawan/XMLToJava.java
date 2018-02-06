package com.parawan;

import java.io.File;

import javax.xml.bind.*;

public class XMLToJava {

    public Places xmlToJava() {
        Places placesFromFile = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(PlacesWrapper.class, Places.class, Place.class, PlaceStatus.class);
            Unmarshaller u = jc.createUnmarshaller();

            u.setEventHandler(
                    new ValidationEventHandler() {
                        public boolean handleEvent(ValidationEvent event ) {
                            throw new RuntimeException(event.getMessage(),
                                    event.getLinkedException());
                        }
                    });

            File f = new File(JavaToXML.DATA_FILE_NAME);
            System.out.println(f.getAbsolutePath());
            placesFromFile = (Places) u.unmarshal(f);

            for(Place onePlace : placesFromFile) {
                System.out.println(onePlace.getId());
                System.out.println(onePlace.getX());
                System.out.println(onePlace.getY());
                System.out.println(onePlace.getStatus());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return placesFromFile;
    }
}