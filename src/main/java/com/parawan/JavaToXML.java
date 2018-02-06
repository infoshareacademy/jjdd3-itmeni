package com.parawan;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaToXML {
    public static final String DATA_FILE_NAME = "moj_output.xml";

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


    public Places createEmptyPlaces() {
        Places places = new Places();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 10; j++) {
                places.add(new Place((i - 1) * 10 + j, i - 1, j - 1, PlaceStatus.FREE));
            }
        }
        return places;
    }

}
