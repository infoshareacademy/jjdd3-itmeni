package com.parawan.reservation;

import com.parawan.Beach;
import com.parawan.PlaceStatus;
import com.parawan.ReservationPreview;
import com.parawan.XMLparser.Places;
import com.parawan.XMLparser.XMLToJava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationPreviewTest {

    private XMLToJava subject;
    private ReservationPreview reservationPreview;

    @BeforeEach
    void setUp() {
        subject = new XMLToJava();
    }

    @Test
    void shouldIndicateCompleteInformationAboutBookedPoint() {
        Places places = subject.xmlToJava("src/test/resources/booking_status.xml");
        Beach beach = new Beach("testbeach", 2, 1);
        beach.setPlaces(places);
        reservationPreview = new ReservationPreview();
        assertTrue(reservationPreview.getPlaceByCoordinates(beach, 0, 0).getStatus() == PlaceStatus.FREE);
    }
    @Test
    void shouldThrowExceptionWhenParametersAreOutOfRange() {
        Beach beach = new Beach("testbeach", 12, 10);
        reservationPreview = new ReservationPreview();
        assertThrows(IllegalArgumentException.class, () -> {
            reservationPreview.getPlaceByCoordinates(beach, 19, 4);
        });
    }
}