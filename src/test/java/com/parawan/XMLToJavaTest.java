package com.parawan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class XMLToJavaTest {

        private String xml;

        @Test
        public void test () {
            System.out.print("Dziala");
        }

        @Test
        public void shouldProperlyReadInputFile () {

                XMLToJava xmlToJava = new XMLToJava();
                Places places = xmlToJava.xmlToJava("src/test/resources/booking_status.xml");
                Place place = places.get(0);

                assertEquals(PlaceStatus.FREE, place.getStatus());

        }
}