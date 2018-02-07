package com.parawan;

import java.io.File;

import javax.xml.bind.*;

public class XMLToJava {

    public Places xmlToJava() {
        PlacesWrapper placesWrapper;
        Places placesFromFile = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(PlacesWrapper.class, Places.class, Place.class, PlaceStatus.class);
            Unmarshaller u = jc.createUnmarshaller();

           u.setEventHandler(
                    new ValidationEventHandler() {
                        public boolean handleEvent(ValidationEvent event ) {
                            System.out.println(event.getMessage());
                            //event.getLinkedException().printStackTrace();
                            return true;
                        }
                    });

            File f = new File(JavaToXML.DATA_FILE_NAME);


            placesWrapper = (PlacesWrapper) u.unmarshal(f);
            placesFromFile = placesWrapper.getPlaces();


        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return placesFromFile;
    }
}