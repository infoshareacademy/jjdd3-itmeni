package com.parawan.xml_parser;

import com.parawan.Place;
import com.parawan.PlaceStatus;
import com.parawan.XMLparser.Places;
import com.parawan.XMLparser.XMLToJava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for reading and writing XML")
public class XMLToJavaTest {

    private static final String PATH = "src/test/resources/booking_status.xml";
    private XMLToJava subject;


    @BeforeEach
    void setUp() {
        subject = new XMLToJava();
    }

    @Test
    @DisplayName("Should properly read input file")
    void shouldProperlyReadInputFile() {
        // Given

        // When
        Places places = subject.xmlToJava(PATH);

        // Then
        Place place = places.get(0);
        assertEquals(PlaceStatus.FREE, place.getStatus());
    }
}