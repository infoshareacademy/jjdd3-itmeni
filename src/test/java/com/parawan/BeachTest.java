package com.parawan;

import com.parawan.reservation.Reservation;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BeachTest {
    @Test
    void isBeachConstructorMaxPlacesProperlyCounted() {
        int x = new Random().nextInt(1000);
        int y = new Random().nextInt(1000);
        Beach testBeach = new Beach("test", x, y);
        assertEquals(x * y, testBeach.getPlaces().size());
    }

    @Test
    void shouldReturnOnePlaceByXY() {
        int x = new Random().nextInt(1000);
        int y = new Random().nextInt(1000);
        Beach testBeach = new Beach("test", x, y);
        int xToGet = new Random().nextInt(x);
        int yToGet = new Random().nextInt(y);
        testBeach.getPlaceByXY(xToGet, yToGet).getId();
        assertTrue(testBeach.getPlaceByXY(xToGet, yToGet).getClass() == Place.class);
    }

}