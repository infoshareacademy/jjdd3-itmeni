package com.parawan;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationPreviewTest {

    private XMLToJava subject;
    private ReservationPreview reservationPreview;

    @BeforeEach
    void setUp(){
        subject = new XMLToJava();
    }

    @Test
    void shouldIndicateCompleteInformationAboutBookedPoint() {
        Places places = subject.xmlToJava("src/test/resources/booking_status.xml");
        Beach beach = new Beach(2, 1);
        beach.setPlaces(places);
        reservationPreview = new ReservationPreview();
        assertTrue(reservationPreview.getPlaceByCoordinates(beach, 0, 0).getStatus() == PlaceStatus.FREE);
    }

    @Test
    void shouldThrowExceptionWhenParametersAreOutOfRange() {
        Beach beach = new Beach(12, 10);
        reservationPreview = new ReservationPreview();
        assertThrows(IllegalArgumentException.class, () -> {
            reservationPreview.getPlaceByCoordinates(beach, 19, 4);
        });
    }
}