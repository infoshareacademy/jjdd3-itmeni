package com.parawan.XMLparser;

import com.parawan.Place;
import com.parawan.PlaceStatus;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.bind.*;

public class XMLToJava{

    public Places xmlToJava(String path){
        PlacesWrapper placesWrapper;
        Places placesFromFile=null;
        try{
            JAXBContext jc=JAXBContext.newInstance(PlacesWrapper.class, Places.class, Place.class, PlaceStatus.class);
            Unmarshaller u=jc.createUnmarshaller();

            u.setEventHandler(
                    event->{
                        System.out.println(event.getMessage());
                        return true;
                    });

            File f=new File(!path.isEmpty() && (path.contains("/") || path.contains("\\")) ? path:getClass().getClassLoader().getResource(JavaToXML.DATA_FILE_NAME).getFile());

            placesWrapper=(PlacesWrapper)u.unmarshal(f);
            placesFromFile=placesWrapper.getPlaces();

        }catch(JAXBException e){
            e.printStackTrace();
        }

        return placesFromFile;
    }
}