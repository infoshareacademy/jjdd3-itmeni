package com.parawan;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaToXML {

    public static final String DATA_FILE_NAME = "booking_status.xml";

    public void savePlacesToXML(Places places) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PlacesWrapper.class, Places.class, Place.class, PlaceStatus.class);

        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(DATA_FILE_NAME);
            PlacesWrapper placesWrapper = new PlacesWrapper();
            placesWrapper.setPlaces(places);
            m.marshal(placesWrapper, fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}